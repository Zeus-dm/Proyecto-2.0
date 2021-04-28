
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
import jdbc.JdbcProducto;
import jdbc.JdbcSucursalProducto;

public class FunProductoSucursal {
    private final Sistema sistema;
    private final Sucursal sucursal;

    public FunProductoSucursal(Sistema sistema, Sucursal sucursal) {
        this.sistema = sistema;
        this.sucursal = sucursal;
    }
    
    public String agregarProducto(String nombre, String marca, String barCode, String stock, String precio, String descripcion) throws SQLException{
        if(sistema.verificarExistenciaProducto(barCode)){
            return TextoErrores.BARCODE_DUPLICADO.getTexto();
        }
        
        Producto producto = new Producto();
        try {
            producto.setNombre(nombre);
            producto.setMarca(marca);
            producto.setBarCode(barCode);
            producto.setPrecio(precio);
            producto.setDescripcion(descripcion);
            producto.setStockTotal(stock);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        JdbcProducto jp = new JdbcProducto();
        jp.insert(producto);
        
        int idMax = jp.ultimoId();
        producto.setIdProducto(idMax);
        
        agregarProductoSucursal(producto.getIdProducto(), sucursal.getIdSucursal(), (int)producto.getStockTotal());
        
        sistema.agregarProducto(producto);
        sucursal.agregarProducto(producto);
        
        return null;
    }
    
    public String agregarProducto(String barCode, String stock) throws SQLException{
        Producto producto = sistema.obtenerProducto(barCode);
        
        Producto nuevoProducto = new Producto();
        try {
            nuevoProducto.setStockTotal(stock);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        producto.setStockTotal(producto.getStockTotal() + nuevoProducto.getStockTotal());
        
        JdbcProducto jp = new JdbcProducto();
        jp.update(producto);
        
        agregarProductoSucursal(producto.getIdProducto(), sucursal.getIdSucursal(), (int)nuevoProducto.getStockTotal());
        
        sistema.modificarProducto(producto.getBarCode(), producto);
        sucursal.agregarProducto(producto);
        
        return null;
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
}
