
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
    /**
     * Esta funcion crea un cliente y  luego  lo inserta en la base de datos, para luego recargar la lista de clientes de sistema
     * @param sistema Actualizamos su lista de clientes
     * @param nombre Nombre del cliente
     * @param edad Edad del cliente
     * @param direccion Direccion del cliente
     * @param telefono Telefono del cliente
     * @param email E-mail del cliente
     * @return Retornamos un String de algun error o null en caso de que todo este correcto
     * @throws SQLException 
     */
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
    
    /**
     * Esta funcion modifica un cliente existente, obtiene los nuevos datos y lo actualiza en el sistema, y luego en la base de datos
     * @param sistema Modificamos el cliente en la lista de clientes
     * @param pos Posicion donde se encuentra el cliente en la lista de clientes
     * @param nombre Nuevo nombre del cliente
     * @param edad Nueva edad del cliente
     * @param direccion Nueva direccion del cliente
     * @param telefono Nuevo telefono del cliente
     * @param email Nuevo e-mail del cliente
     * @return Retornamos un String de algun error o null en caso de que todo este correcto
     * @throws SQLException 
     */
    public static String modificarCliente(Sistema sistema, int pos, String nombre, String edad, String direccion, String telefono, String email) throws SQLException {
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
        sistema.modificarCliente(pos, cliente);
        
        cliente = sistema.getClientes().get(pos);
                
        JdbcCliente jc = new JdbcCliente();
        jc.update(cliente);
        
        return null;
    }
    
    /**
     * Esta funcion elimina un cliente existente en la base de datos para luego eliminarlo de la lista del sistema
     * @param sistema Eliminamos el cliente de la lista de clientes
     * @param pos Posicion donde se encuentra el cliente en la lista de clientes
     * @throws SQLException 
     */
    public static void eliminarCliente(Sistema sistema, int pos) throws SQLException {
        Cliente cliente = sistema.getClientes().get(pos);

        JdbcCliente jc = new JdbcCliente();
        jc.delete(cliente);
        
        sistema.eliminarCliente(pos);
    }
    
    /**
     * Esta funcion obtiene todos los clientes de la base de datos
     * @return Retorna una lista de clientes
     * @throws SQLException 
     */
    public static List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        JdbcCliente jc = new JdbcCliente();
        
        List<IGenerico> genericos = jc.select();
        
        genericos.forEach(generico -> {
            clientes.add((Cliente)generico);
        });
        
        return clientes;
    }
    
    /**
     * Esta funcion obtiene la lista de clientes del sistema, y la transforma en una lista de solo sus nombres
     * @param sistema Obtenemos su lista de clientes
     * @return Retorna una lista de String con los nombres de los clientes
     */
    public static List<String> ListarNombresClientes(Sistema sistema){
        List<String> nombreClientes = new ArrayList<>();
        
        sistema.getClientes().forEach(cliente -> {
            nombreClientes.add(cliente.getNombre());
        });
        
        return nombreClientes;
    }
    
    /**
     * Esta funcion obtiene el sistema y la posicion, y obtiene los datos del cliente en especifico
     * @param sistema Obtenemos el cliente de la lista de clientes
     * @param pos Posicion donde se encuentra el cliente en la lista del sistema
     * @return Retorna una lista de Strings con los datos del cliente en especifico
     */
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