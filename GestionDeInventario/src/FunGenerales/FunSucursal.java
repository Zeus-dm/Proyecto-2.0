
package FunGenerales;

import domain.IGenerico;
import domain.JefeSucursal;
import domain.Producto;
import domain.Region;
import domain.Sucursal;
import domain.SucursalProducto;
import enumeraciones.TextoErrores;
import excepciones.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcJefeSucursal;
import jdbc.JdbcSucursal;

public class FunSucursal {
    private final Region region;

    public FunSucursal(Region region) {
        this.region = region;
    }
    
    public String agregarSucursal(String nombre, String direccion, String telefono) throws SQLException {
        Sucursal sucursal = new Sucursal();
        try {
            sucursal.setIdRegion(region.getIdRegion());
            sucursal.setNombre(nombre);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        if(region.verificarExistenciaSucursal(nombre)){
            return TextoErrores.SUCURSAL_DUPLICADO.getTexto();
        }
        
        JdbcSucursal js = new JdbcSucursal() ;
        js.insert(sucursal);
        
        int maxId = js.ultimoId();
        sucursal.setIdSucursal(maxId);
        
        region.agregarSucursal(sucursal);
        
        return null ;
    }
    
    public String modificarSucursal(String preNombre, String nombre, String direccion, String telefono)throws SQLException {
        if(region.verificarExistenciaSucursal(nombre)){
            return TextoErrores.SUCURSAL_DUPLICADO.getTexto();
        }
        
        Sucursal preSucursal = region.obtenerSucursal(preNombre);
        Sucursal sucursal = new Sucursal();
        try {
            sucursal.setIdRegion(region.getIdRegion());
            sucursal.setNombre(nombre);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);
            
            sucursal.setIdSucursal(preSucursal.getIdSucursal());
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        region.modificarSucursal(preNombre, sucursal);
        
        JdbcSucursal js = new JdbcSucursal() ;
        js.update(sucursal);
        
        return null ;
    }
    
    public void eliminarSucursal(String nombre) throws SQLException {
        Sucursal sucursal = region.obtenerSucursal(nombre);
        
        //Eliminar los productos de la sucursal, los sucursalesProducto y el jefe
        
        //Termina de eliminar los productos, los sucursalesProducto y el jefe
        
        JdbcSucursal js = new JdbcSucursal();
        js.delete(sucursal);
        
        region.eliminarSucursal(nombre);
    }
    
    public void listarSucursales() throws SQLException {
        JdbcSucursal js = new JdbcSucursal() ;
        
        List<IGenerico> nuevoG = js.selectList(region.getIdRegion());
        
        nuevoG.forEach(generico -> {
            Sucursal sucursal = (Sucursal)generico;
            region.agregarSucursal(sucursal);
        });
    }
    
    public List<String> nombresSucursales() {
        return region.nombresSucursales();
    }

    //----------------------------------------------------
    private static String verificarDatosJefe(String nombre, String edad) {  
        
        if(nombre==null || nombre.isEmpty()) {
            return "*Error: Campo Nombre vacío" ;
        }
        
        if(edad == null || edad.isEmpty()) {
            return "*Error: Campo edad vacío" ;
        }else {
            try{
                int edadAux = Integer.parseInt(edad) ;
                if (edadAux < 18 || edadAux > 130) {
                    return "*Error: Campo edad  fuera de rango" ;
                }
            }catch (NumberFormatException e) {
                return "*Error: Campo edad no es un número" ;
            }
        }
        
        return null;
    }
    
    public static String agregarJefe(String nombre, String edad, int idSucursal) throws SQLException {
        
        String verificar = verificarDatosJefe(nombre, edad);
        if(verificar != null){
            return verificar;
        }
        int edadAux = Integer.parseInt(edad);
        
        JefeSucursal newJ = new JefeSucursal(nombre, edadAux, idSucursal);
        JdbcJefeSucursal jjs = new JdbcJefeSucursal() ;
        
        jjs.insert(newJ);
        
        return null ;
    }
    
    public static void eliminarJefe(int idSucursal) throws SQLException {
        JefeSucursal newJ = new JefeSucursal(idSucursal);
        JdbcJefeSucursal jjs = new JdbcJefeSucursal() ;
        
        jjs.delete(newJ);
    }
    
    public static String modificarJefe(int idSucursal, String nombre, String edad) throws SQLException {
        
        String verificar = verificarDatosJefe(nombre, edad);
        if(verificar != null){
            return verificar;
        }
        int edadAux = Integer.parseInt(edad);
        
        JdbcJefeSucursal jjs = new JdbcJefeSucursal() ;
        JefeSucursal newJ = (JefeSucursal) jjs.select(idSucursal) ;
        
        newJ.setNombre(nombre);
        newJ.setEdad(edadAux);
        
        jjs.update(newJ);
        
        return null ;
    }

    public static JefeSucursal selecJefe(int idSucursal) throws SQLException {
        JdbcJefeSucursal jjs = new JdbcJefeSucursal() ;
        
        JefeSucursal newJ = (JefeSucursal) jjs.select(idSucursal);
        
        return newJ;
    }
    
    //-----------------------------------------------------
    public String nombreRegion(){
        return region.getNombre();
    }
}
