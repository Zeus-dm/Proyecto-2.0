
package FunGenerales;

import domain.IGenerico;
import domain.Producto;
import domain.Sistema;
import domain.Sucursal;
import domain.SucursalProducto;
import enumeraciones.TextoErrores;
import excepciones.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jdbc.JdbcProducto;
import jdbc.JdbcSucursal;
import jdbc.JdbcSucursalProducto;

public class FunProducto { 
    private final Sistema sistema;

    public FunProducto(Sistema sistema) {
        this.sistema = sistema;
    }
    
    public String agregarProducto(String nombre, String marca, String barCode, String precio, String descripcion) throws SQLException{
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
            producto.setStockTotal(0);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        JdbcProducto jp = new JdbcProducto();
        jp.insert(producto);
        
        int idMax = jp.ultimoId();
        producto.setIdProducto(idMax);
        
        sistema.agregarProducto(producto);
        
        return null;
    }

    public String modificarProducto(String preBarCode, String nombre, String marca, String barCode, String precio, String descripcion) throws SQLException {
        if(!(preBarCode.equals(barCode))){
            if(sistema.verificarExistenciaProducto(barCode)){
                return TextoErrores.BARCODE_DUPLICADO.getTexto();
            }
        }
        
        Producto preProducto = sistema.obtenerProducto(preBarCode);
        Producto producto = new Producto();
        try {
            producto.setNombre(nombre);
            producto.setMarca(marca);
            producto.setBarCode(barCode);
            producto.setPrecio(precio);
            producto.setDescripcion(descripcion);
            
            producto.setIdProducto(preProducto.getIdProducto());
            producto.setStockTotal(preProducto.getStockTotal());
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException | TextoEmailException e){
            return e.getMessage();
        }
        
        sistema.modificarProducto(preBarCode, producto);

        JdbcProducto jp = new JdbcProducto();
        jp.update(producto);
        
        return null;
    }
    
    public void listarProductos() throws SQLException {
        JdbcProducto jp = new JdbcProducto();
        
        Map<String,IGenerico> genericos = jp.select();
        
        for (IGenerico generico : genericos.values()) {
            Producto producto = (Producto)generico;
            sistema.agregarProducto(producto);
        }
    }
    
    public List<String> filtrarProductos(int min, int max, String textoBuscar){
        return sistema.filtrarProductos(min, max, textoBuscar);
    }
    
    public List<String> todosProductos(){
        return sistema.todosProductos();
    }
    
    public List<String> todosBarCodes(){
        return sistema.todosBarCodes();
    }
    
    public List<String> productosFiltrados(){
        return sistema.productosFiltrados();
    }

    public List<String> seleccionarProducto(String barCode){
        List<String> textos = new ArrayList<>();
        
        Producto producto = sistema.obtenerProducto(barCode);
        
        textos.add(producto.getNombre());
        textos.add(producto.getMarca());
        textos.add(producto.getBarCode());
        textos.add(""+producto.getPrecio());
        textos.add(""+producto.getStockTotal());
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
    
    public List<String> listarMarcas(){
        return sistema.marcasProductos();
    }
    
    public List<Integer> cantidadProductosMarca(){
        return sistema.cantidadProductosMarca();
    }
    
    //------------------
    
    public void listarSucursalStock(String barCode, List<String> nombresSucursales, List<Integer> stocksSucursales) throws SQLException{
        Producto producto = sistema.obtenerProducto(barCode);
        
        List<SucursalProducto> listaSP = listarSucursalProducto(producto.getIdProducto());
        for (SucursalProducto sp : listaSP) {
            Sucursal sucursal = obtenerSucursal(sp.getIdSucursal());
            
            nombresSucursales.add(sucursal.getNombre());
            stocksSucursales.add(sp.getStock());
        }
    }

    private List<SucursalProducto> listarSucursalProducto (int idProducto) throws SQLException {
        List<SucursalProducto> listaSP = new ArrayList<>() ;
        JdbcSucursalProducto jsp = new JdbcSucursalProducto() ;
        
        List<IGenerico> listaGenericos = jsp.selectP(idProducto);
        
        listaGenericos.forEach(iGenerico -> {
            listaSP.add((SucursalProducto)iGenerico) ;
        });
        
        return listaSP ;
    }
    
    private Sucursal obtenerSucursal(int idSucursal) throws SQLException {
        JdbcSucursal js = new JdbcSucursal();
        
        return (Sucursal) js.select(idSucursal);
    }
}