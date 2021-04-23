
package domain;

import java.util.ArrayList;
import java.util.List;

public class CollectionClientes {
    private final List<Cliente> listaClientes;
    private final List<String> nombresClientes;
    private final List<Integer> idsClientes;

    public CollectionClientes() {
        listaClientes = new ArrayList<>();
        nombresClientes = new ArrayList<>();
        idsClientes = new ArrayList<>();
    }
    
    //METODOS
    public Cliente obtenerCliente(int idCliente){
        for (Cliente cliente : listaClientes) {
            if(cliente.getIdCliente() == idCliente){
                return cliente;
            }
        }
        return null;
    }
    
    public void agregarCliente(Cliente cliente){
        listaClientes.add(cliente);
        nombresClientes.add(cliente.getNombre());
        idsClientes.add(cliente.getIdCliente());
    }
    
    public void eliminarCliente(int idCliente){
        for (int i = 0; i < listaClientes.size(); i++) {
            if(listaClientes.get(i).getIdCliente() == idCliente){
                listaClientes.remove(i);
                nombresClientes.remove(i);
                idsClientes.remove(i);
                break;
            }
        }
    }
    
    public void modificarCliente(int idCliente, Cliente nuevoCliente){
        for (int i = 0; i < listaClientes.size(); i++) {
            if(listaClientes.get(i).getIdCliente() == idCliente){
                listaClientes.set(i, nuevoCliente);
                nombresClientes.set(i, nuevoCliente.getNombre());
                idsClientes.set(i, nuevoCliente.getIdCliente());
                break;
            }
        }
    }
    
    public List<String> obtenerNombres(){
        return nombresClientes;
    }
    
    public List<Integer> obtenerIds(){
        return idsClientes;
    }
}
