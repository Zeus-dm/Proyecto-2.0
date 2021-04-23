
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
    private final Sistema sistema;

    public FunCliente(Sistema sistema) {
        this.sistema = sistema;
    }
    
    /**
     * Esta funcion crea un cliente y  luego  lo inserta en la base de datos, para luego recargar la lista de clientes de sistema
     * @param nombre Nombre del cliente
     * @param edad Edad del cliente
     * @param direccion Direccion del cliente
     * @param telefono Telefono del cliente
     * @param email E-mail del cliente
     * @return Retornamos un String de algun error o null en caso de que todo este correcto
     * @throws SQLException 
     */
    public String agregarCliente(String nombre, String edad, String direccion, String telefono, String email) throws SQLException {
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
        
        int maxId = jc.ultimoId();
        cliente.setIdCliente(maxId);
        
        sistema.agregarCliente(cliente);
        
        return null;
    }
    
    /**
     * Esta funcion modifica un cliente existente, obtiene los nuevos datos y lo actualiza en el sistema, y luego en la base de datos
     * @param idCliente ID del cliente
     * @param nombre Nuevo nombre del cliente
     * @param edad Nueva edad del cliente
     * @param direccion Nueva direccion del cliente
     * @param telefono Nuevo telefono del cliente
     * @param email Nuevo e-mail del cliente
     * @return Retornamos un String de algun error o null en caso de que todo este correcto
     * @throws SQLException 
     */
    public String modificarCliente(int idCliente, String nombre, String edad, String direccion, String telefono, String email) throws SQLException {
        Cliente cliente = new Cliente();
        try {
            cliente.setNombre(nombre);
            cliente.setEdad(edad);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            cliente.setEmail(email);
            cliente.setIdCliente(idCliente);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException | TextoEmailException e){
            return e.getMessage();
        }
        
        sistema.modificarCliente(idCliente, cliente);
        
        JdbcCliente jc = new JdbcCliente();
        jc.update(cliente);
        
        return null;
    }
    
    /**
     * Esta funcion elimina un cliente existente en la base de datos para luego eliminarlo de la lista del sistema 
     * @param idCliente ID del cliente
     * @throws SQLException 
     */
    public void eliminarCliente(int idCliente) throws SQLException {
        Cliente cliente = sistema.obtenerCliente(idCliente);

        JdbcCliente jc = new JdbcCliente();
        jc.delete(cliente);
        
        sistema.eliminarCliente(idCliente);
    }
    
    /**
     * Esta funcion obtiene todos los clientes de la base de datos y los carga al sistema
     * @throws SQLException 
     */
    public void listarClientes() throws SQLException {
        JdbcCliente jc = new JdbcCliente();
        
        List<IGenerico> genericos = jc.select();
        
        genericos.forEach(generico -> {
            Cliente cliente = (Cliente)generico;
            sistema.agregarCliente(cliente);
        });
    }
    
    /**
     * Esta funcion obtiene la lista de los nombres de los clientes
     * @return Retorna una lista de String con los nombres de los clientes
     */
    public List<String> nombresClientes(){
        return sistema.nombresClientes();
    }
    
    /**
     * Esta funcion obtiene la lista de los ids de los clientes
     * @return Retorna una lista de int con los ids de los clientes
     */
    public List<Integer> idsClientes(){
        return sistema.idsClientes();
    }
    
    /**
     * Esta funcion obtiene el sistema y la posicion, y obtiene los datos del cliente en especifico
     * @param idCliente ID del cliente
     * @return Retorna una lista de Strings con los datos del cliente en especifico
     */
    public List<String> seleccionarCliente(int idCliente){
        List<String> textos = new ArrayList<>();
        
        Cliente cliente = sistema.obtenerCliente(idCliente);
        
        textos.add(cliente.getNombre());
        textos.add(""+cliente.getEdad());
        textos.add(cliente.getDireccion());
        textos.add(cliente.getTelefono());
        textos.add(cliente.getEmail());
        
        return textos;
    }
}