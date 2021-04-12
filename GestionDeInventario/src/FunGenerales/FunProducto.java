
package FunGenerales;

import domain.IGenerico;
import domain.Producto;
import domain.Sistema;
import domain.Sucursal;
import enumeraciones.TextoErrores;
import excepciones.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jdbc.JdbcProducto;

public class FunProducto {
    public static String verificarExistencia(Map<String,Producto> productos, Producto producto ,String barCode) {
        Producto productoAux = productos.get(barCode);
        if(productoAux != null && productoAux.getIdProducto() != producto.getIdProducto() ){
            return TextoErrores.BARCODE_DUPLICADO.getTexto();
        }
        
        return null;
    }
    
    public static String agregarProducto(Sucursal sucursal, String nombre, String barCode, String precio, String stock, String descripcion) throws SQLException {
        Producto producto = new Producto(-1); 
        //como es un producto nuevo para luego verificar con los demas necesita un id obligatoriamente distinto a todos los de la base de datos, por lo tanto se ocupa el -1.
        try {
            producto.setNombre(nombre);
            producto.setBarCode(barCode);
            producto.setPrecio(precio);
            producto.setStockTotal(stock);
            producto.setDescripcion(descripcion);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        String verificar = verificarExistencia(listarProductos(), producto, barCode);
        if(verificar != null){
            return verificar;
        }
        
        JdbcProducto jp = new JdbcProducto();
        jp.insert(producto);
        
        //llama a la funcion de sucursal producto
        
        return null;
    }
    
    public static String modificarProducto(Map<String,Producto> productos,String barCodeProducto, String nombre, String barCode, String precio, String descripcion) throws SQLException {
        Producto producto = productos.get(barCodeProducto);
        try {
            producto.setNombre(nombre);
            producto.setBarCode(barCode);
            producto.setPrecio(precio);
            producto.setDescripcion(descripcion);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        String verificar = verificarExistencia(productos, producto, barCode);
        if(verificar != null){
            return verificar;
        }else if( !(barCodeProducto.equals(producto.getBarCode())) ){
            productos.remove(barCodeProducto);
            productos.put(producto.getBarCode(), producto);
        }
        
        JdbcProducto jp = new JdbcProducto();
        jp.update(producto);
        
        return null;
    }
    
    /**
     * Esta funcion mapea todos los productos de la base de datos
     * @return Retorna un mapa de productos con su barcode como key
     * @throws SQLException 
     */
    public static Map<String,Producto> listarProductos() throws SQLException {
        Producto producto;
        
        Map<String,Producto> productos = new HashMap<>();
        
        JdbcProducto jp = new JdbcProducto();
        Map<String,IGenerico> genericos = jp.select();
        
        for (IGenerico generico : genericos.values()) {
            producto = (Producto)generico;
            productos.put(producto.getBarCode(), producto);
        }
        
        return productos;
    }
    
    /**
     * Esta funcion lista todos los nombres de los productos que esten en el rango "min - max"
     * @param sistema Filtrar productos
     * @param min Precio minimo del producto
     * @param max Precio maximo del producto
     * @return Retorna una lista de String con solo los nombres de los productos
     */
    public static List<String> listarProductos(Sistema sistema, int min, int max){
        
        Map<String,Producto> productos = sistema.filtrarProductosPrecio(min, max);
        List<String> nombreProductos = new ArrayList<>();
        
        productos.values().forEach(producto -> {
            nombreProductos.add(producto.getNombre());
        });
        
        return nombreProductos;
    }
    
    /**
     * Esta funcion lista todos los nombres de los productos que contengan el String ingresado
     * @param sistema Filtrar productos
     * @param textoBuscar Texto a buscar en los nombres de los productos
     * @return Retorna una lista de String con solo los nombres de los productos
     */
    public static List<String> listarProductos(Sistema sistema, String textoBuscar) {

        Map<String,Producto> productos = sistema.filtrarProductosNombre(textoBuscar);
        List<String> nombreProductos = new ArrayList<>();
        
        productos.values().forEach(producto -> {
            nombreProductos.add(producto.getNombre());
        });
        
        return nombreProductos;
    }
    
    /**
     * Esta funcion lista todos los nombres de los productos que esten en el rango "min - max" y que contengan el String ingresado
     * @param sistema Filtrar productos
     * @param min Precio minimo
     * @param max Precio maximo
     * @param textoBuscar Texto a buscar en los nombres de los productos
     * @return Retorna una lista de String con solo los nombres de los productos
     */
    public static List<String> listarProductos(Sistema sistema, int min, int max, String textoBuscar){
        
        if( (min == 0) && (max == 0) && !(textoBuscar.isEmpty()) ){
            return listarProductos(sistema, textoBuscar);
        }else if( (min > 0) && (max > 0) && (textoBuscar.isEmpty()) ){
            return listarProductos(sistema, min, max);
        }else if( (min > 0) && (max > 0) && !(textoBuscar.isEmpty()) ){
            Map<String,Producto> productos = sistema.filtrarProductosPrecioNombre(min, max, textoBuscar);
            List<String> nombreProductos = new ArrayList<>();
        
            productos.values().forEach(producto -> {
                nombreProductos.add(producto.getNombre());
            });
        
            return nombreProductos;
        }
        
        return listarNombresTodosProductos(sistema);
    }
    
    /**
     * Esta funcion verifica si el min y el max son numero, y que el max sea mayor que el min, en caso contrario retorna error
     * @param min Numero minimo
     * @param max Numero maximo
     * @return Retornamos un String de algun error o null en caso de que todo este correcto
     */
    public static String verificarMinMax(String min, String max){
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
    
    /**
     * Esta funcion toma todos los nombres de los productos y los inserta en una lista
     * @param sistema Obtiene su mapa de productos
     * @return Retorna una lista de String con solo los nombres de los productos
     */
    public static List<String> listarNombresTodosProductos(Sistema sistema){
        List<String> nombreProductos = new ArrayList<>();
        
        sistema.getProductos().values().forEach(producto -> {
            nombreProductos.add(producto.getNombre());
        });
        
        return nombreProductos;
    }
    
    
}
