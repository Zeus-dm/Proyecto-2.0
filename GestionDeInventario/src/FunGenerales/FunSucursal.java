
package FunGenerales;

import domain.IGenerico;
import domain.Region;
import domain.Sucursal;
import excepciones.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.JdbcSucursal;

public class FunSucursal {
    public static String agregarSucursal(int idRegion, String nombre, String direccion, String telefono) throws SQLException {
        Sucursal sucursal = new Sucursal();
        try {
            sucursal.setIdRegion(idRegion);
            sucursal.setNombre(nombre);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        JdbcSucursal js = new JdbcSucursal();
        js.insert(sucursal);
        
        return null;
    }
    
    public static String modificarSucursal(List<Sucursal> sucursales, int pos, int idRegion, String nombre, String direccion, String telefono) throws SQLException {
        Sucursal sucursal = sucursales.get(pos);
        try {
            sucursal.setIdRegion(idRegion);
            sucursal.setNombre(nombre);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);            
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        JdbcSucursal js = new JdbcSucursal();
        js.update(sucursal);
        
        return null;
    }
    
    public static void eliminarSucursal(List<Sucursal> sucursales, int pos) throws SQLException {
        Sucursal sucursal = sucursales.get(pos);
        
        JdbcSucursal js = new JdbcSucursal();
        js.delete(sucursal);
        
        sucursales.remove(pos);
    }
    
    public static List<Sucursal> listarSucursales(Region region) throws SQLException {
        List<Sucursal> sucursales = new ArrayList<>();
        JdbcSucursal js = new JdbcSucursal();
        
        List<IGenerico> genericos = js.selectList(region.getIdRegion());
        
        genericos.forEach(generico -> {
            sucursales.add((Sucursal)generico);
        });
        
        return sucursales;
    }
    
    public static List<String> seleccionarSucursal(List<Sucursal> sucursales, int pos) {
        List<String> textos = new ArrayList<>();
        
        Sucursal sucursal = sucursales.get(pos);
        
        textos.add(sucursal.getNombre());
        textos.add(sucursal.getDireccion());
        textos.add(sucursal.getTelefono());
        
        return textos;
    }
    
    public static Sucursal seleccionarSucursal (int idSucursal) throws SQLException {
        JdbcSucursal js = new JdbcSucursal() ;
        
        Sucursal newS = (Sucursal) js.select(idSucursal) ;
        
        return newS ;
    }
    
    //--------------------------------------------------------------------------------
    //Funciones para despues
}
