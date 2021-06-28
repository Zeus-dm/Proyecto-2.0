
package FunGenerales;

import domain.IGenerico;
import domain.JefeSucursal;
import domain.Region;
import domain.Sistema;
import domain.Sucursal;
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
    private final Sistema sistema;

    public FunSucursal(Region region, Sistema sistema) {
        this.region = region;
        this.sistema = sistema;
    }
    
    public String agregarSucursal(String nombre, String direccion, String telefono) throws SQLException {
        Sucursal sucursal = new Sucursal();
        try {
            sucursal.setIdRegion(region.getIdRegion());
            sucursal.setNombre(nombre);
            sucursal.setTelefono(telefono);
            sucursal.setDireccion(direccion);
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
            sucursal.setTelefono(telefono);
            sucursal.setDireccion(direccion);
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
        
        Sucursal sucursal = region.obtenerSucursal(preNombre);
        try {
            sucursal.setIdRegion(region.getIdRegion());
            sucursal.setNombre(nombre);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        region.modificarSucursal(preNombre, sucursal.getNombre());
                
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
        
        FunProductoSucursal controladorProductoSucursal = new FunProductoSucursal(sistema, sucursal);
        List<String> todosBarCodes = sucursal.todosBarCodes();
        for (int i = 0; i < todosBarCodes.size(); i++) {
            controladorProductoSucursal.eliminarProducto(todosBarCodes.get(i));
        }
        //Termina de eliminar los productos y el jefe
        
        JdbcSucursal js = new JdbcSucursal();
        js.delete(sucursal);
        
        region.eliminarSucursal(nombre);
    }
    
    public void listarSucursales(Sistema sistema) throws SQLException {
        JdbcSucursal js = new JdbcSucursal() ;
        
        List<IGenerico> nuevoG = js.selectList(region.getIdRegion());
        
        nuevoG.forEach(generico -> {
            Sucursal sucursal = (Sucursal)generico;
            //obtenemos el jefe de la sucursal
            try {
                sucursal.setJefeSucursal(obtenerJefe(sucursal.getIdSucursal()));
                
                FunProductoSucursal fps = new FunProductoSucursal(sistema, sucursal);
                fps.listarProductos();
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
    
    public void eliminarJefe(String nombreSucursal) throws SQLException {
        Sucursal sucursal = region.obtenerSucursal(nombreSucursal);
        JefeSucursal jefe = sucursal.getJefeSucursal();
        
        JdbcJefeSucursal jjs = new JdbcJefeSucursal() ;
        
        jjs.delete(jefe);
        sucursal.setJefeSucursal(null);
    }
    
    public String modificarJefe(String nombreSucursal, String nombre, String edad) throws SQLException {
        Sucursal sucursal = region.obtenerSucursal(nombreSucursal);
        
        JefeSucursal jefe = new JefeSucursal();
        try {
            jefe.setIdSucursal(sucursal.getIdSucursal());
            jefe.setNombre(nombre);
            jefe.setEdad(edad);
        } catch(TextoEnBlancoException | NumeroFormatException | NumeroRangoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        JdbcJefeSucursal jjs = new JdbcJefeSucursal();
        jjs.update(jefe);
        
        sucursal.setJefeSucursal(jefe);
        
        return null ;
    }

    private JefeSucursal obtenerJefe(int idSucursal) throws SQLException {
        JdbcJefeSucursal jjs = new JdbcJefeSucursal() ;
        
        JefeSucursal jefe = (JefeSucursal) jjs.select(idSucursal);
        
        return jefe;
    }
    
    public List<String> seleccionarJefe(String nombreSucursal){
        List<String> textos = new ArrayList<>();
        
        Sucursal sucursal = region.obtenerSucursal(nombreSucursal);
        JefeSucursal jefe = sucursal.getJefeSucursal();
        
        textos.add(jefe.getNombre());
        textos.add(""+jefe.getEdad());
        
        return textos;
    }
    
    //-----------------------------------------------------
    public String nombreRegion(){
        return region.getNombre();
    }
}
