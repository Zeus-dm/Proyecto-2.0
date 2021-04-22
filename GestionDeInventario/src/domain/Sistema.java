
package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema {
    private final CollectionRegiones regiones;
    private List<Cliente> clientes = null;
    private Map<String,Producto> productos = null;
    private Usuario usuario = null;

    public Sistema() {
        regiones = new CollectionRegiones();
    }
    
    //GETTERS
    public List<Cliente> getClientes() {
        return clientes;
    }

    public Map<String, Producto> getProductos() {
        return productos;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    //SETTERS
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setProductos(Map<String, Producto> productos) {
        this.productos = productos;
    }

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
    public void eliminarCliente(int pos){
        clientes.remove(pos);
    }
    
    public void modificarCliente(int pos, Cliente cliente){
        Cliente preCliente = clientes.get(pos);
        
        preCliente.setNombre(cliente.getNombre());
        preCliente.setEdad(cliente.getEdad());
        preCliente.setDireccion(cliente.getDireccion());
        preCliente.setTelefono(cliente.getTelefono());
        preCliente.setEmail(cliente.getEmail());
    }
    
    //METODOS PRODUCTOS
    public Map<String, Producto> filtrarProductosPrecio(int min, int max){
        Map<String,Producto> productosFiltrados = new HashMap<>();
        
        for(Producto producto : productos.values()) {
            if( (producto.getPrecio() >= min) && (producto.getPrecio() <= max) ){
                productosFiltrados.put(producto.getBarCode(), producto);
            }
        }
        return productosFiltrados;
    }
    
    public Map<String, Producto> filtrarProductosNombre(String textoBuscar){
        Map<String,Producto> productosFiltrados = new HashMap<>();
        
        for(Producto producto : productos.values()) {
            if(producto.getNombre().toLowerCase().contains(textoBuscar.toLowerCase())){
                productosFiltrados.put(producto.getBarCode(), producto);
            }
        }
        return productosFiltrados;
    }
    
    public Map<String, Producto> filtrarProductosPrecioNombre(int min, int max, String textoBuscar){
        Map<String,Producto> productosFiltrados = new HashMap<>();
        
        for(Producto producto : productos.values()) {
            if( (producto.getPrecio() >= min) && (producto.getPrecio() <= max) && (producto.getNombre().toLowerCase().contains(textoBuscar.toLowerCase())) ){
                productosFiltrados.put(producto.getBarCode(), producto);
            }
        }
        return productosFiltrados;
    }
    
    public List<String> marcasProductos(){
        List<String> listaMarcas = new ArrayList<>();
        boolean flag;
        
        for (Producto producto : productos.values()) {
            flag = true;
            for (String marca : listaMarcas) {
                if(marca.equals(producto.getMarca())){
                    flag = false;
                    break;
                }
            }
            if(flag){
                listaMarcas.add(producto.getMarca());
            }
        }
        
        return listaMarcas;
    }
    
    public List<Integer> cantidadProductosMarca(List<String> marcas){
        List<Integer> cantidadProductos = new ArrayList<>();
        int cont;
        
        for (String marca : marcas) {
            cont = 0;
            for (Producto producto : productos.values()) {
                if(marca.equals(producto.getMarca())){
                    cont++;
                }
            }
            cantidadProductos.add(cont);
        }
        
        return cantidadProductos;
    }
    
    public boolean verificarExistenciaProducto(String barCode){
        Producto producto = productos.get(barCode);
        return producto != null;
    }
    
    public void modificarProducto(String preBarCode, Producto producto){
        Producto preProducto = productos.get(preBarCode);
        
        preProducto.setNombre(producto.getNombre());
        preProducto.setMarca(producto.getMarca());
        preProducto.setBarCode(producto.getBarCode());
        preProducto.setPrecio(producto.getPrecio());
        preProducto.setDescripcion(producto.getDescripcion());
        
        if(!(preBarCode.equals(producto.getBarCode()))){
            productos.remove(preBarCode);
            productos.put(preProducto.getBarCode(), preProducto);
        }
    }
    
    //METODOS REGIONES
    public boolean verificarExistenciaRegion(String nombre){
        return regiones.verificarExistencia(nombre);
    }
    
    public Region obtenerRegion(String nombre){
        return regiones.obtenerRegion(nombre);
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