
package domain;

import java.util.ArrayList;
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
}
