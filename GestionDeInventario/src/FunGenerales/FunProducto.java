
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jdbc.JdbcProducto;
import jdbc.JdbcSucursalProducto;

public class FunProducto { 
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
        
        /*String verificar = verificarExistencia(listarProductos(), producto, barCode);
        if(verificar != null){
            return verificar;
        }*/
        
        JdbcProducto jp = new JdbcProducto();
        jp.insert(producto);
        
        //llama a la funcion de sucursal producto
        
        return null;
    }
    
    /**
     * Esta funcion obtiene los nuevos parametro que debe contener un producto en particular
     * @param sistema Modificar el producto exacto en su interior
     * @param preBarCode Obtenemos la key anterior, si se cambio ese parametro
     * @param nombre Obtenemos el nuevo nombre
     * @param marca Obtenemos la nueva marca
     * @param barCode Obtenemos el nuevo barCode, el cual seria la key
     * @param precio Obtenemos el nuevo precio del producto
     * @param descripcion Obtenemos la nueva descripcion del producto
     * @return Retornamos un String de algun error o null en caso de que todo este correcto
     * @throws SQLException 
     */
    public static String modificarProducto(Sistema sistema, String preBarCode, String nombre, String marca, String barCode, String precio, String descripcion) throws SQLException {
        
        if(!(preBarCode.equals(barCode))){
            if(sistema.verificarExistenciaProducto(barCode)){
                return TextoErrores.BARCODE_DUPLICADO.getTexto();
            }
        }
        
        Producto producto = new Producto();
        try {
            producto.setNombre(nombre);
            producto.setMarca(marca);
            producto.setBarCode(barCode);
            producto.setPrecio(precio);
            producto.setDescripcion(descripcion);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException | TextoEmailException e){
            return e.getMessage();
        }
        
        sistema.modificarProducto(preBarCode, producto);
        
        producto = sistema.getProductos().get(barCode);
       
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
     * @param barCodesFiltrados Lista con los barCodes de los productos
     * @return Retorna una lista de String con solo los nombres de los productos
     */
    public static List<String> listarProductos(Sistema sistema, int min, int max, List<String> barCodesFiltrados){
        barCodesFiltrados.removeAll(barCodesFiltrados);
        
        Map<String,Producto> productos = sistema.filtrarProductosPrecio(min, max);
        List<String> nombreProductos = new ArrayList<>();
        
        productos.values().forEach(producto -> {
            nombreProductos.add(producto.getNombre());
            barCodesFiltrados.add(producto.getBarCode());
        });
        
        return nombreProductos;
    }
    
    /**
     * Esta funcion lista todos los nombres de los productos que contengan el String ingresado
     * @param sistema Filtrar productos
     * @param textoBuscar Texto a buscar en los nombres de los productos
     * @param barCodesFiltrados Lista con los barCodes de los productos
     * @return Retorna una lista de String con solo los nombres de los productos
     */
    public static List<String> listarProductos(Sistema sistema, String textoBuscar, List<String> barCodesFiltrados) {
        barCodesFiltrados.removeAll(barCodesFiltrados);
        
        Map<String,Producto> productos = sistema.filtrarProductosNombre(textoBuscar);
        List<String> nombreProductos = new ArrayList<>();
        
        productos.values().forEach(producto -> {
            nombreProductos.add(producto.getNombre());
            barCodesFiltrados.add(producto.getBarCode());
        });
        
        return nombreProductos;
    }
    
    /**
     * Esta funcion lista todos los nombres de los productos que esten en el rango "min - max" y que contengan el String ingresado
     * @param sistema Filtrar productos
     * @param min Precio minimo
     * @param max Precio maximo
     * @param textoBuscar Texto a buscar en los nombres de los productos
     * @param barCodesFiltrados Obtenemos los barcodes de los productos filtrados
     * @return Retorna una lista de String con solo los nombres de los productos
     */
    public static List<String> listarProductos(Sistema sistema, int min, int max, String textoBuscar, List<String> barCodesFiltrados){
        barCodesFiltrados.removeAll(barCodesFiltrados);
        
        if( (min == 0) && (max == 0) && !(textoBuscar.isEmpty()) ){
            return listarProductos(sistema, textoBuscar, barCodesFiltrados);
        }else if( (min > 0) && (max > 0) && (textoBuscar.isEmpty()) ){
            return listarProductos(sistema, min, max, barCodesFiltrados);
        }else if( (min > 0) && (max > 0) && !(textoBuscar.isEmpty()) ){
            Map<String,Producto> productos = sistema.filtrarProductosPrecioNombre(min, max, textoBuscar);
            List<String> nombreProductos = new ArrayList<>();
        
            productos.values().forEach(producto -> {
                nombreProductos.add(producto.getNombre());
                barCodesFiltrados.add(producto.getBarCode());
            });
        
            return nombreProductos;
        }
        
        return listarNombresTodosProductos(sistema, barCodesFiltrados);
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
     * @param barCodesFiltrados Lista con los barCodes de los productos
     * @return Retorna una lista de String con solo los nombres de los productos
     */
    public static List<String> listarNombresTodosProductos(Sistema sistema, List<String> barCodesFiltrados){
        barCodesFiltrados.removeAll(barCodesFiltrados);
        
        List<String> nombreProductos = new ArrayList<>();
        
        sistema.getProductos().values().forEach(producto -> {
            nombreProductos.add(producto.getNombre());
            barCodesFiltrados.add(producto.getBarCode());
        });
        
        return nombreProductos;
    }
    
    /**
     * Esta funcion obtiene el producto y luego de este obtiene los nombres de las sucursales donde este esta, ademas de sus stocks en cada sucursal en especifico
     * @param sistema Obtener el producto del su mapa
     * @param barCode Key del mapa para obtener el producto
     * @param nombresSucursales Lista que se actualizara con los nombres de las sucursales
     * @param stocksSucursales Lista que se actualizara con los stocks
     * @throws SQLException 
     */
    public static void listarNombresSucursalesStocksProducto(Sistema sistema, String barCode, List<String> nombresSucursales, List<Integer> stocksSucursales) throws SQLException{
        Producto producto = sistema.getProductos().get(barCode);
        
        List<SucursalProducto> listaSP = listarSucursalProducto(producto.getIdProducto());
        for (SucursalProducto sp : listaSP) {
            Sucursal sucursal = FunSucursal.seleccionarSucursal(sp.getIdSucursal());
            
            nombresSucursales.add(sucursal.getNombre());
            stocksSucursales.add(sp.getStock());
        }
    }
    
    /**
     * Esta funcion obtiene la lista de todos los ids de las sucursales que tienen a ese producto con sus stocks
     * @param idProducto Parametro para obtener los datos de la base de datos
     * @return Retorna una lista de SucursalProducto la cual tiene los ids de las sucursales y los stocks correspondientes
     * @throws SQLException 
     */
    public static List<SucursalProducto> listarSucursalProducto (int idProducto) throws SQLException {
        List<SucursalProducto> listaSP = new ArrayList<>() ;
        JdbcSucursalProducto jsp = new JdbcSucursalProducto() ;
        
        List<IGenerico> listaGenericos = jsp.selectP(idProducto);
        
        listaGenericos.forEach(iGenerico -> {
            listaSP.add((SucursalProducto)iGenerico) ;
        });
        
        return listaSP ;
    }
    
    /**
     * Esta funcion obtiene el barcode y retorna los datos del producto
     * @param sistema Para tener el mapa de productos
     * @param barCode Para buscarlo en el mapa
     * @return Retorna una lista de String con los datos del producto
     */
    public static List<String> seleccionarProducto(Sistema sistema, String barCode){
        List<String> textos = new ArrayList<>();
        
        Producto producto = sistema.getProductos().get(barCode);
        
        textos.add(producto.getNombre());
        textos.add(producto.getMarca());
        textos.add(producto.getBarCode());
        textos.add(""+producto.getPrecio());
        textos.add(""+producto.getStockTotal());
        textos.add(producto.getDescripcion());
        
        return textos;
    }
    
    /**
     * Esta funcion retorana una lista de todas las marcas de los productos y la cantidad de productos diferentes que posee
     * @param sistema Obtenemos las marcas y las cantidades
     * @param marcas Guardan las Marcas diferentes
     * @param cantidades Guardan las cantidades de productos diferentes que existen por cada marca
     */
    public static void listarMarcasCantidadesProducto(Sistema sistema, List<String> marcas, List<Integer> cantidades){
        sistema.marcasProductos().forEach(marca -> {
            marcas.add(marca);
        });
        
        sistema.cantidadProductosMarca(marcas).forEach(cantidad -> {
            cantidades.add(cantidad);
        });
    }
}