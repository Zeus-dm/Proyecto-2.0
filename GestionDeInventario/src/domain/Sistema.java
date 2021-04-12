
package domain;

import excepciones.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema {
    private List<Region> regiones = null;
    private List<Cliente> clientes = null;
    private Map<String,Producto> productos = null;
    private Usuario usuario = null;

    public Sistema() {
    }
    
    //GETTERS
    public List<Region> getRegiones() {
        return regiones;
    }

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
    public void setRegiones(List<Region> regiones) {
        this.regiones = regiones;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setProductos(Map<String, Producto> productos) {
        this.productos = productos;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    //METODOS   
    public boolean verificarExistenciaUsuario(){
        return usuario != null;
    }
    
    public void eliminarCliente(int pos){
        clientes.remove(pos);
    }
    
    public String modificarCliente(int pos, String nombre, String edad, String direccion, String telefono, String email){
        Cliente cliente = clientes.get(pos);
        try {
            cliente.setNombre(nombre);
            cliente.setEdad(edad);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            cliente.setEmail(email);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException | TextoEmailException e){
            return e.getMessage();
        }
        
        return null;
    }
    
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
}
