
package FunGenerales;

import domain.IGenerico;
import domain.Region;
import domain.Sistema;
import excepciones.*;
import enumeraciones.TextoErrores;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.JdbcRegion;

public class FunRegion {
    private final Sistema sistema;

    public FunRegion(Sistema sistema) {
        this.sistema = sistema;
    }
    
    /**
     * Esta funcion agregar una nueva region si esta no existe previamente
     * @param nombre Nombre de la nueva region
     * @return Retorna un String con algun error, y null si todo salio bien
     * @throws SQLException 
     */
    public String agregarRegion(String nombre) throws SQLException {
        //Verificamos que todo esta correcto
        Region region = new Region();
        try {
            region.setNombre(nombre);
        } catch(TextoEnBlancoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        if(sistema.verificarExistenciaRegion(nombre)){
            return TextoErrores.REGION_DUPLICADO.getTexto();
        }
        
        //agregamos la region a la base de datos
        JdbcRegion jr = new JdbcRegion();
        jr.insert(region);
        
        //obtenemos el id de la region previamente agregada y se inserta en la region
        int maxId = jr.ultimoId();
        region.setIdRegion(maxId);
        
        sistema.agregarRegion(region);
        
        return null;
    }
    
    /**
     * Esta funcion modifica una region existente, obtiene los nuevos datos y lo actualiza en el sistema, y luego en la base de datos
     * @param preNombre Nombre de la region antes de modificar
     * @param nombre Nuevo nombre de la region
     * @return Retornamos un String de algun error o null en caso de que todo este correcto
     * @throws SQLException 
     */
    public String modificarRegion(String preNombre, String nombre) throws SQLException {
        if(!(preNombre.equals(nombre))){
            if(sistema.verificarExistenciaRegion(nombre)){
                return TextoErrores.REGION_DUPLICADO.getTexto();
            }
        }
                
        Region preRegion = sistema.obtenerRegion(preNombre);
        Region region = new Region();
        try {
            region.setNombre(nombre);
            region.setIdRegion(preRegion.getIdRegion());
        } catch(TextoEnBlancoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }

        sistema.modificarRegion(preNombre, region);
        
        JdbcRegion jr = new JdbcRegion();
        jr.update(region);
        
        return null;
    }
    
    /**
     * Esta funcion elimina una region existente en la base de datos para luego eliminarlo de la lista del sistema
     * @param nombre Nombre de la region a eliminar
     * @throws SQLException
     */
    public void eliminarRegion(String nombre) throws SQLException {
        Region region = sistema.obtenerRegion(nombre);
        
        //Eliminar sucursales de la region en especifico
        FunSucursal controladorSucursal = new FunSucursal(region);
        List<String> nombresSucursales = region.nombresSucursales();
        for (int i = 0; i < nombresSucursales.size(); i++) {
            controladorSucursal.eliminarSucursal(nombresSucursales.get(i));
        }
        //Termina de eliminar las Sucursales
        
        JdbcRegion jr = new JdbcRegion();
        jr.delete(region);
        
        sistema.eliminarRegion(nombre);
    }
    
    /**
     * Esta funcion obtiene todas las regiones de la base de datos y las carga al sistema
     * @throws SQLException 
     */
    public void listarRegiones() throws SQLException {
        JdbcRegion jc = new JdbcRegion();
        
        List<IGenerico> genericos = jc.select();
        
        genericos.forEach(generico -> {
            Region region = (Region)generico;
            //agrega las sucursales de la region
            try {
                FunSucursal controladorSucursal = new FunSucursal(region);
                controladorSucursal.listarSucursales(sistema);
            } catch (SQLException ex) {
                Logger.getLogger(FunRegion.class.getName()).log(Level.SEVERE, null, ex);
            }
            //termina de agregar las sucursales
            sistema.agregarRegion(region);
        });
    }
    
    /**
     * Esta funcion obtiene la lista de regiones del sistema, y la transforma a una lista de solo sus nombres
     * @return Retorna una lista de String con los nombres de las regiones
     */
    public List<String> nombresRegiones(){
        return sistema.nombresRegiones();
    }
}
