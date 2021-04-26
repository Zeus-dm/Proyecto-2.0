
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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public String agregarSucursal(String nombre, String direccion, String telefono, String nombreJefe, String edadJefe) throws SQLException {
        //Verificar datos de la sucursal
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
        //Verificar datos del jefe de la sucursal
        JefeSucursal jefe = new JefeSucursal();
        try {
            jefe.setNombre(nombreJefe);
            jefe.setEdad(edadJefe);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        //Insertar la sucursal en la base de datos
        JdbcSucursal js = new JdbcSucursal() ;
        js.insert(sucursal);
        
        int maxId = js.ultimoId();
        sucursal.setIdSucursal(maxId);
        //Insertar el Jefe de la sucursal en la base de datos
        jefe.setIdSucursal(sucursal.getIdSucursal());
        
        JdbcJefeSucursal jjs = new JdbcJefeSucursal();
        jjs.insert(jefe);
        
        //Inserta el jefe en la sucursal y luego inserta la sucursal en la region
        sucursal.setJefeSucursal(jefe);
        
        region.agregarSucursal(sucursal);
        
        return null;
    }
    
    public String modificarSucursal(String preNombre, String nombre, String direccion, String telefono)throws SQLException {
        if(!(preNombre.equals(nombre))){
            if(region.verificarExistenciaSucursal(nombre)){
                return TextoErrores.SUCURSAL_DUPLICADO.getTexto();
            }
        }       
        
        Sucursal preSucursal = region.obtenerSucursal(preNombre);
        Sucursal sucursal = new Sucursal();
        try {
            sucursal.setIdRegion(region.getIdRegion());
            sucursal.setNombre(nombre);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);
            
            sucursal.setIdSucursal(preSucursal.getIdSucursal());
            sucursal.setJefeSucursal(preSucursal.getJefeSucursal());
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
        if(sucursal.verificarExistenciaJefe()){
            eliminarJefe(sucursal.getNombre());
        }
        
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
            //obtenemos el jefe de la sucursal
            try {
                sucursal.setJefeSucursal(obtenerJefe(sucursal.getIdSucursal()));
            } catch (SQLException ex) {
                Logger.getLogger(FunSucursal.class.getName()).log(Level.SEVERE, null, ex);
            }
            //termina de obtener al jefe
            region.agregarSucursal(sucursal);
        });
    }
    
    public List<String> nombresSucursales() {
        return region.nombresSucursales();
    }
    
    public List<String> seleccionarSucursal(String nombre){
        List<String> textos = new ArrayList<>();
        
        Sucursal sucursal = region.obtenerSucursal(nombre);
        JefeSucursal jefe = sucursal.getJefeSucursal();
        
        textos.add(sucursal.getNombre());
        textos.add(sucursal.getDireccion());
        textos.add(sucursal.getTelefono());
        if(jefe == null){
            textos.add("N/a");
            textos.add("N/a");
        }else{
            textos.add(jefe.getNombre());
            textos.add(""+jefe.getEdad());
        }
        
        return textos;
    }
    
    //----------------------------------------------------  
    public boolean verificarExistenciaJefe(String nombreSucursal){
        Sucursal sucursal = region.obtenerSucursal(nombreSucursal);
        return sucursal.verificarExistenciaJefe();
    }
    
    public String agregarJefe(String nombreSucursal, String nombre, String edad) throws SQLException {
        Sucursal sucursal = region.obtenerSucursal(nombreSucursal);
        JefeSucursal jefe = new JefeSucursal();
        try {
            jefe.setIdSucursal(sucursal.getIdSucursal());
            jefe.setNombre(nombre);
            jefe.setEdad(edad);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        JdbcJefeSucursal jjs = new JdbcJefeSucursal() ;
        jjs.insert(jefe);
        
        sucursal.setJefeSucursal(jefe);
        
        return null ;
    }
    
    private void eliminarJefe(String nombreSucursal) throws SQLException {
        Sucursal sucursal = region.obtenerSucursal(nombreSucursal);
        JefeSucursal jefe = sucursal.getJefeSucursal();
        
        JdbcJefeSucursal jjs = new JdbcJefeSucursal() ;
        
        jjs.delete(jefe);
    }
    
    public static String modificarJefe(int idSucursal, String nombre, String edad) throws SQLException {
        /*
        String verificar = verificarDatosJefe(nombre, edad);
        if(verificar != null){
            return verificar;
        }
        int edadAux = Integer.parseInt(edad);
        
        JdbcJefeSucursal jjs = new JdbcJefeSucursal() ;
        JefeSucursal newJ = (JefeSucursal) jjs.select(idSucursal) ;
        
        newJ.setNombre(nombre);
        newJ.setEdad(edadAux);
        
        jjs.update(newJ);*/
        
        return null ;
    }

    private JefeSucursal obtenerJefe(int idSucursal) throws SQLException {
        JdbcJefeSucursal jjs = new JdbcJefeSucursal() ;
        
        JefeSucursal jefe = (JefeSucursal) jjs.select(idSucursal);
        
        return jefe;
    }
    
    //-----------------------------------------------------
    public String nombreRegion(){
        return region.getNombre();
    }
}
