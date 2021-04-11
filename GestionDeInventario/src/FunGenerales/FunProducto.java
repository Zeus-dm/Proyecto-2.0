
package FunGenerales;

import domain.IGenerico;
import domain.Producto;
import domain.Sucursal;
import enumeraciones.TextoErrores;
import excepciones.*;
import java.sql.SQLException;
import java.util.HashMap;
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
}
