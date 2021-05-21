
package domain;

import java.util.List;

public class Sistema {
    private final CollectionRegiones regiones;
    private final CollectionPersonas clientes;
    private final CollectionProductos productos;
    private Usuario usuario = null;

    public Sistema() {
        regiones = new CollectionRegiones();
        clientes = new CollectionPersonas();
        productos = new CollectionProductos();
    }
    
    //GETTERS
    public Usuario getUsuario() {
        return usuario;
    }
    
    //SETTERS
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    //METODOS USUARIO   
    public boolean verificarExistenciaUsuario(){
        return usuario != null;
    }
    
    public void eliminarUsuario(){
        usuario = null;
    }
    
    //METODOS CLIENTES
    public Cliente obtenerCliente(int idCliente){
        return (Cliente)clientes.obtenerPersona(idCliente);
    }
    
    public void agregarCliente(Cliente cliente){
        clientes.agregarPersona(cliente);
    }
    
    public void eliminarCliente(int idCliente){
        clientes.eliminarPersona(idCliente);
    }
    
    public void modificarCliente(int idCliente, Cliente nuevoCliente){
        clientes.modificarPersona(idCliente, nuevoCliente);
    }
    
    public List<String> nombresClientes(){
        return clientes.obtenerNombres();
    }
    
    public List<Integer> idsClientes(){
        return clientes.obtenerIds();
    }
    
    //METODOS PRODUCTOS
    public boolean verificarExistenciaProducto(String barCode){
        return productos.verificarExistencia(barCode);
    }
    
    public Producto obtenerProducto(String barCode){
        return productos.obtenerProducto(barCode);
    }
    
    public Producto obtenerProducto(int idProducto){
        return productos.obtenerProducto(idProducto);
    }
    
    public void agregarProducto(Producto producto){
        productos.agregarProducto(producto);
    }
    
    public void eliminarProducto(String barCode){
        productos.eliminarProducto(barCode);
    }
    
    public void modificarProducto(String preBarCode, Producto nuevoProducto){
        productos.modificarProducto(preBarCode, nuevoProducto);
    }
    
    public List<String> todosProductos(){
        return productos.todosProductos();
    }
    
    public List<String> todosBarCodes(){
        return productos.todosBarCodes();
    }
    
    public List<String> productosFiltrados(){
        return productos.productosFiltrados();
    }

    public List<String> filtrarProductos(int min, int max, String textoBuscar){
        if( (min == 0) && (max == 0) && (textoBuscar.isEmpty()) ){
            return productos.todosProductos();
        }else if( (min == 0) && (max == 0) && !(textoBuscar.isEmpty()) ){
            return productos.filtrarProductos(textoBuscar);
        }else if( (min >= 0) && (max >= 0) && (textoBuscar.isEmpty()) ){
            return productos.filtrarProductos(min, max);
        }else if( (min >= 0) && (max >= 0) && !(textoBuscar.isEmpty()) ){
            return productos.filtrarProductos(min, max, textoBuscar);
        }
        return productos.todosProductos();
    }
    
    public List<String> marcasProductos(){
        return productos.todasMarcas();
    }
    
    public List<Integer> cantidadProductosMarca(){
        return productos.cantidadProductosMarca();
    }
    
    //METODOS REGIONES
    public boolean verificarExistenciaRegion(String nombre){
        return regiones.verificarExistencia(nombre);
    }
    
    public Region obtenerRegion(String nombre){
        return regiones.obtenerRegion(nombre);
    }
    
    public Region obtenerRegion(int idRegion){
        return regiones.obtenerRegion(idRegion);
    }
    
    public void agregarRegion(Region region){
        regiones.agregarRegion(region);
    }
    
    public void eliminarRegion(String nombre){
        regiones.eliminarRegion(nombre);
    }
    
    public void modificarRegion(String preNombre, Region nuevaRegion){
        regiones.modificarRegion(preNombre, nuevaRegion);
    }
    
    public List<String> nombresRegiones(){
        return regiones.obtenerNombres();
    }
}