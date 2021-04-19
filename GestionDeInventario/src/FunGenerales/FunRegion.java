
package FunGenerales;

import domain.IGenerico;
import domain.Region;
import domain.Sistema;
import excepciones.*;
import enumeraciones.TextoErrores;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.JdbcRegion;

public class FunRegion {
    /**
     * Esta funcion agregar una nueva region si esta no existe previamente
     * @param sistema obtenemos si la region ya existe, ademas de luego actualizar sus regiones
     * @param nombre Nombre de la nueva region
     * @return Retorna un String con algun error, y null si todo salio bien
     * @throws SQLException 
     */
    public static String agregarRegion(Sistema sistema, String nombre) throws SQLException {
        Region region = new Region();
        try {
            region.setNombre(nombre);
        } catch(TextoEnBlancoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        if(sistema.verificarExistenciaRegion(nombre)){
            return TextoErrores.REGION_DUPLICADO.getTexto();
        }
        
        JdbcRegion jr = new JdbcRegion();
        jr.insert(region);
        
        sistema.setRegiones( listarRegiones() );
        
        return null;
    }
    
    /**
     * Esta funcion modifica una region existente, obtiene los nuevos datos y lo actualiza en el sistema, y luego en la base de datos
     * @param sistema Modificamos la region en la lista de regiones
     * @param pos Posicion donde se encuentra la region en la lista de regiones
     * @param nombre Nuevo nombre de la region
     * @return Retornamos un String de algun error o null en caso de que todo este correcto
     * @throws SQLException 
     */
    public static String modificarRegion(Sistema sistema, int pos, String nombre) throws SQLException {
        Region region = new Region();
        try {
            region.setNombre(nombre);
        } catch(TextoEnBlancoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        if(sistema.verificarExistenciaRegion(nombre)){
            return TextoErrores.REGION_DUPLICADO.getTexto();
        }
        sistema.modificarRegion(pos, region);
        
        region = sistema.getRegiones().get(pos);
        
        JdbcRegion jr = new JdbcRegion();
        jr.update(region);
        
        return null;
    }
    
    /**
     * Esta funcion elimina una region existente en la base de datos para luego eliminarlo de la lista del sistema
     * @param sistema Eliminamos la region de la lista de regiones
     * @param pos Posicion donde se encuentra la region en la lista de regiones
     * @throws SQLException
     */
    public static void eliminarRegion(Sistema sistema, int pos) throws SQLException {
        Region region = sistema.getRegiones().get(pos);
        //Falta el aliminar sucursales de la region en especifico
        
        JdbcRegion jr = new JdbcRegion();
        jr.delete(region);
        
        sistema.eliminarRegion(pos);
    }
    
    /**
     * Esta funcion obtiene todas las regiones de la base de datos
     * @return Retorna una lista de regiones
     * @throws SQLException 
     */
    public static List<Region> listarRegiones() throws SQLException {
        List<Region> regiones = new ArrayList<>();
        JdbcRegion jc = new JdbcRegion();
        
        List<IGenerico> genericos = jc.select();
        
        genericos.forEach(generico -> {
            regiones.add((Region)generico);
        });
        
        return regiones;
    }
    
    /**
     * Esta funcion obtiene la lista de regiones del sistema, y la transforma a una lista de solo sus nombres
     * @param sistema Obtenemos su lista de clientes
     * @return Retorna una lista de String con los nombres de las regiones
     */
    public static List<String> ListarNombresRegiones(Sistema sistema){
        List<String> nombreRegiones = new ArrayList<>();
        
        sistema.getRegiones().forEach(region -> {
            nombreRegiones.add(region.getNombre());
        });
        
        return nombreRegiones;
    }
}
