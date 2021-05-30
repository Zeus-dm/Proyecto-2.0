
package FunGenerales;

import domain.IGenerico;
import domain.Producto;
import domain.Region;
import domain.Sistema;
import domain.Sucursal;
import domain.SucursalProducto;
import enumeraciones.TextoErrores;
import excepciones.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.JdbcProducto;
import jdbc.JdbcSucursalProducto;

public class FunProductoSucursal {
    private final Sistema sistema;
    private final Sucursal sucursal;

    public FunProductoSucursal(Sistema sistema, Sucursal sucursal) {
        this.sistema = sistema;
        this.sucursal = sucursal;
    }
    
    public String agregarProducto(String barCode, String stock) throws SQLException{
        Producto producto = sistema.obtenerProducto(barCode);
        
        Producto nuevoProducto = new Producto();
        try {
            nuevoProducto.setStockTotal(stock);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        if(nuevoProducto.getStockTotal() == 0){
            return TextoErrores.STOCK_MAYOR_CERO.getTexto();
        }
        
        producto.setStockTotal(producto.getStockTotal() + nuevoProducto.getStockTotal());
        
        JdbcProducto jp = new JdbcProducto();
        jp.update(producto);
        
        agregarProductoSucursal(producto.getIdProducto(), sucursal.getIdSucursal(), (int)nuevoProducto.getStockTotal());
        
        sistema.modificarProducto(producto.getBarCode(), producto);
        sucursal.agregarProducto(producto);
        
        return null;
    }
    
    public String modificarStockProducto(String barCode, String nuevoStock) throws SQLException{
        Producto producto = sucursal.obtenerProducto(barCode);
        SucursalProducto sp = obtenerProductoSucursal(producto.getIdProducto(), sucursal.getIdSucursal());
        
        Producto nuevoProducto = new Producto();
        try {
            nuevoProducto.setStockTotal(nuevoStock);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        if(nuevoProducto.getStockTotal() == 0){
            eliminarProducto(barCode);
            return null;
        }
        
        int diferenciaStock = (int) (nuevoProducto.getStockTotal() - sp.getStock());
        
        producto.setStockTotal(producto.getStockTotal() + diferenciaStock);
        JdbcProducto jp = new JdbcProducto();
        jp.update(producto);
        
        sistema.modificarProducto(producto.getBarCode(), producto);
        
        sp.setStock((int)nuevoProducto.getStockTotal());
        modificarProductoSucursal(sp);
        
        return null;
    }
    
    public void eliminarProducto(String barCode) throws SQLException{
        Producto producto = sucursal.obtenerProducto(barCode);
        SucursalProducto sp = obtenerProductoSucursal(producto.getIdProducto(), sucursal.getIdSucursal());
        
        producto.setStockTotal(producto.getStockTotal() - sp.getStock());
        JdbcProducto jp = new JdbcProducto();
        jp.update(producto);
        
        sistema.modificarProducto(producto.getBarCode(), producto);
        
        sucursal.eliminarProducto(barCode);
        eliminarProductoSucursal(sp);
    }
    
    public void listarProductos() throws SQLException {
        List<SucursalProducto> listaSP = listarProductoSucursal(sucursal.getIdSucursal());
        
        for (SucursalProducto sp : listaSP) {
            sucursal.agregarProducto(sistema.obtenerProducto(sp.getIdProducto()));
        }
    }
    
    public List<String> filtrarProductos(int min, int max, String textoBuscar){
        return sucursal.filtrarProductos(min, max, textoBuscar);
    }
    
    public List<String> todosProductos(){
        return sucursal.todosProductos();
    }
    
    public List<String> todosBarCodes(){
        return sucursal.todosBarCodes();
    }
    
    public List<String> productosFiltrados(){
        return sucursal.productosFiltrados();
    }
    
    public List<String> seleccionarProducto(String barCode) {
        List<String> textos = new ArrayList<>();
        
        Producto producto = sucursal.obtenerProducto(barCode);
        if(producto == null){
            return null;
        }
        
        textos.add(producto.getNombre());
        textos.add(producto.getMarca());
        textos.add(producto.getBarCode());
        textos.add(""+producto.getPrecio());

        try {
            SucursalProducto sp;
            sp = obtenerProductoSucursal(producto.getIdProducto(), sucursal.getIdSucursal());
            textos.add(""+sp.getStock());
        } catch (SQLException ex) {
            Logger.getLogger(FunProductoSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        textos.add(producto.getDescripcion());
        
        return textos;
    }
    
    public String verificarMinMax(String min, String max){
        if(min.isEmpty()){
            return TextoErrores.MIN_VACIO.getTexto();
        }else if(max.isEmpty()){
            return TextoErrores.MAX_VACIO.getTexto();
        }
        int minAux;
        int maxAux;
        
        try{
            minAux = Integer.parseInt(min);
        }catch(NumberFormatException ex){
            return TextoErrores.MIN_INVALIDO.getTexto();
        }
        try{
            maxAux = Integer.parseInt(max);
        }catch(NumberFormatException ex){
            return TextoErrores.MAX_INVALIDO.getTexto();
        }
        
        if(maxAux < minAux){
            return TextoErrores.MIN_MAYOR_MAX.getTexto();
        }
        
        return null;
    }
    
    public List<String> barCodesNoSucursal(){
        List<String> barCodesSistema = sistema.todosBarCodes();
        
        List<String> barCodesNoSucursal = new ArrayList<>();
        for (String barCode : barCodesSistema) {
            Producto producto = sucursal.obtenerProducto(barCode);
            if(producto == null){
                barCodesNoSucursal.add(barCode);
            }
        }
        
        return barCodesNoSucursal;
    }
    
    public List<String> nombresNoSucursal(){
        List<String> nombresNoSucursal = new ArrayList<>();
        
        for (String barCode : barCodesNoSucursal()) {
            Producto producto = sistema.obtenerProducto(barCode);
            nombresNoSucursal.add(producto.getNombre());
        }
        
        return nombresNoSucursal;
    }
    
    //---------------------------------------------------
    private void agregarProductoSucursal(int idProducto, int idSucursal, int Stock) throws SQLException{
        JdbcSucursalProducto jsp = new JdbcSucursalProducto();
        
        SucursalProducto sp = new SucursalProducto(idProducto, idSucursal, Stock);
        jsp.insert(sp);
    }
    
    private SucursalProducto obtenerProductoSucursal(int idProducto, int idSucursal) throws SQLException{
        JdbcSucursalProducto jsp = new JdbcSucursalProducto();
        
        SucursalProducto sp = (SucursalProducto)jsp.select(idProducto, idSucursal);
        return sp;
    }
    
    private void modificarProductoSucursal(SucursalProducto sp) throws SQLException{
        JdbcSucursalProducto jsp = new JdbcSucursalProducto();
        jsp.update(sp);
    }
    
    private void eliminarProductoSucursal(SucursalProducto sp) throws SQLException{
        JdbcSucursalProducto jsp = new JdbcSucursalProducto();
        jsp.delete(sp);
    }
    
    private List<SucursalProducto> listarProductoSucursal (int idSucursal) throws SQLException{
        List<SucursalProducto> listaSP = new ArrayList<>() ;
        JdbcSucursalProducto jsp = new JdbcSucursalProducto() ;
        
        List<IGenerico> listaGenericos = jsp.selectS(idSucursal);
        
        listaGenericos.forEach(iGenerico -> {
            listaSP.add((SucursalProducto)iGenerico) ;
        });
        
        return listaSP ;
    }
    
    //-----------------------------------------------------
    public String nombreSucursal(){
        return sucursal.getNombre();
    }
    
    public String nombreRegion(){
        Region region = sistema.obtenerRegion(sucursal.getIdRegion());
        return region.getNombre();
    }
    
    public String nombreProducto(String barCode){
        Producto producto = sucursal.obtenerProducto(barCode);
        return producto.getNombre();
    }
    
    public String stockProductoSucursal(String barCode) throws SQLException{
        Producto producto = sucursal.obtenerProducto(barCode);
        SucursalProducto sp = obtenerProductoSucursal(producto.getIdProducto(), sucursal.getIdSucursal());
        return "" + sp.getStock();
    }
}
