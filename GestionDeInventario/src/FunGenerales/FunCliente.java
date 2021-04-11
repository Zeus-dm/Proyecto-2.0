
package FunGenerales;

import domain.Cliente;
import domain.IGenerico;
import domain.Sistema;
import java.util.List;
import excepciones.*;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.JdbcCliente;

public class FunCliente {
    public static String agregarCliente(Sistema sistema, String nombre, String edad, String direccion, String telefono, String email) throws SQLException {
        Cliente cliente = new Cliente();
        try {
            cliente.setNombre(nombre);
            cliente.setEdad(edad);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            cliente.setEmail(email);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException | TextoEmailException e){
            return e.getMessage();
        }
        
        JdbcCliente jc = new JdbcCliente();
        jc.insert(cliente);
        
        sistema.setClientes( listarClientes() );
        
        return null;
    }
    
    public static String modificarCliente(List<Cliente> clientes, int pos, String nombre, String edad, String direccion, String telefono, String email) throws SQLException {
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
        
        JdbcCliente jc = new JdbcCliente();
        jc.update(cliente);
        
        return null;
    }
    
    public static void eliminarCliente(List<Cliente> clientes, int pos) throws SQLException {
        Cliente cliente = clientes.get(pos);
        
        JdbcCliente jc = new JdbcCliente();
        jc.delete(cliente);
        
        clientes.remove(pos);
    }
    
    public static List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        JdbcCliente jc = new JdbcCliente();
        
        List<IGenerico> genericos = jc.select();
        
        genericos.forEach(generico -> {
            clientes.add((Cliente)generico);
        });
        
        return clientes;
    }
    
    public static List<String> ListarNombresClientes(Sistema sistema){
        List<String> nombreClientes = new ArrayList<>();
        
        sistema.getClientes().forEach(cliente -> {
            nombreClientes.add(cliente.getNombre());
        });
        
        return nombreClientes;
    }
    
    public static List<String> seleccionarCliente(Sistema sistema, int pos) {
        List<String> textos = new ArrayList<>();
        
        Cliente cliente = sistema.getClientes().get(pos);
        
        textos.add(cliente.getNombre());
        textos.add(""+cliente.getEdad());
        textos.add(cliente.getDireccion());
        textos.add(cliente.getTelefono());
        textos.add(cliente.getEmail());
        
        return textos;
    }
}
