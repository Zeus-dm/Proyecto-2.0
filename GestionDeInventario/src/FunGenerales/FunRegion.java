
package FunGenerales;

import domain.IGenerico;
import domain.Region;
import excepciones.*;
import enumeraciones.TextoErrores;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.JdbcRegion;

public class FunRegion {
    public static String verificarExistencia(List<Region> regiones, String nombre) {
        for (Region region : regiones) {
            if(nombre.equalsIgnoreCase(region.getNombre())){
                return TextoErrores.REGION_DUPLICADO.getTexto();
            }
        }
        
        return null;
    }
    
    public static String agregarRegion(String nombre) throws SQLException {
        Region region = new Region();
        try {
            region.setNombre(nombre);
        } catch(TextoEnBlancoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        String verificar = verificarExistencia(listarRegiones(), nombre);
        if(verificar != null){
            return verificar;
        }
        
        JdbcRegion jr = new JdbcRegion();
        jr.insert(region);
        
        return null;
    }
    
    public static String modificarRegion(List<Region> regiones, int pos, String nombre) throws SQLException {
        Region region = regiones.get(pos);
        try {
            region.setNombre(nombre);
        } catch(TextoEnBlancoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        String verificar = verificarExistencia(regiones, nombre);
        if(verificar != null){
            return verificar;
        }
        
        JdbcRegion jr = new JdbcRegion();
        jr.update(region);
        
        return null;
    }
    
    public static void eliminarRegion(List<Region> regiones, int pos) throws SQLException {
        Region region = regiones.get(pos);
        
        JdbcRegion jr = new JdbcRegion();
        jr.delete(region);
        
        regiones.remove(pos);
    }
    
    public static List<Region> listarRegiones() throws SQLException {
        List<Region> regiones = new ArrayList<>();
        JdbcRegion jc = new JdbcRegion();
        
        List<IGenerico> genericos = jc.select();
        
        genericos.forEach(generico -> {
            regiones.add((Region)generico);
        });
        
        return regiones;
    }
}
