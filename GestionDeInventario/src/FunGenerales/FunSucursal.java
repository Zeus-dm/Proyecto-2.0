
package FunGenerales;

import domain.IGenerico;
import domain.JefeSucursal;
import domain.Region;
import domain.Sistema;
import domain.Sucursal;
import excepciones.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.JdbcJefeSucursal;
import jdbc.JdbcSucursal;

public class FunSucursal {
    public static String agregarSucursal(Sistema sistema, int posRegion, String nombre, String direccion, String telefono) throws SQLException {
        Sucursal sucursal = new Sucursal();
        try {
            sucursal.setIdRegion(sistema.getRegiones().get(posRegion).getIdRegion());
            sucursal.setNombre(nombre);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        JdbcSucursal js = new JdbcSucursal();
        js.insert(sucursal);
        
        sistema.getRegiones().get(posRegion).setSucursales( listarSucursales(sistema.getRegiones().get(posRegion).getIdRegion()) );
        
        return null;
    }
    
    public static String agregarSucursal(Sistema sistema, int posRegion, String nombre, String direccion, String telefono, String nombreJefe, String edadJefe) throws SQLException {
        Sucursal sucursal = new Sucursal();
        try {
            sucursal.setIdRegion(sistema.getRegiones().get(posRegion).getIdRegion());
            sucursal.setNombre(nombre);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        JefeSucursal jefe = new JefeSucursal();
        try {
            jefe.setNombre(nombreJefe);
            jefe.setEdad(edadJefe);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        JdbcSucursal js = new JdbcSucursal();
        JdbcJefeSucursal jjs = new JdbcJefeSucursal();
        
        js.insert(sucursal);
        
        List<Sucursal> sucursales = listarSucursales(sistema.getRegiones().get(posRegion).getIdRegion());
        jefe.setIdSucursal(sucursales.get(sucursales.size()-1).getIdSucursal());
        
        jjs.insert(jefe);
        
        sistema.getRegiones().get(posRegion).setSucursales( listarSucursales(sistema.getRegiones().get(posRegion).getIdRegion()) );

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
    
    public static List<Sucursal> listarSucursales(int idRegion) throws SQLException {
        List<Sucursal> sucursales = new ArrayList<>();
        JdbcSucursal js = new JdbcSucursal();
        JdbcJefeSucursal jjs = new JdbcJefeSucursal();
        
        List<IGenerico> genericos = js.selectList(idRegion);
        
        genericos.forEach(generico -> {
            Sucursal sucursal = (Sucursal)generico; 
            try {
                JefeSucursal jefe = (JefeSucursal) jjs.select(sucursal.getIdSucursal());
                if(jefe != null){
                    sucursal.setJefeSucursal(jefe);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FunSucursal.class.getName()).log(Level.SEVERE, null, ex);
            }

            sucursales.add(sucursal);
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
    
    public static List<String> ListarNombresSucursales(Sistema sistema, int posRegion){
        //Region region = sistema.getRegiones().get(posRegion);
        List<String> nombreSucursales = new ArrayList<>();
        
        sistema.getRegiones().get(posRegion).getSucursales().forEach(sucursal -> {
            nombreSucursales.add(sucursal.getNombre());
        });
        
        return nombreSucursales;
    }
    
    //--------------------------------------------------------------------------------
    //Funciones para despues
}
