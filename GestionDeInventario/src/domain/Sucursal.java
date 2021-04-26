
package domain;

import enumeraciones.TextoErrores;
import excepciones.*;
import java.util.Map;

public class Sucursal implements IGenerico{
    private int idSucursal ;
    private int idRegion ;
    private String nombre ;
    private String direccion ;
    private String telefono ;
    private JefeSucursal jefeSucursal = null;
    private Map <String,Producto> productos ;
    
    public Sucursal() {       
    }
    
    public Sucursal(int idSucursal) {
        this.idSucursal = idSucursal ;
    }
    
    public Sucursal(int idRegion, String nombre, String direccion, String telefono) {
        this.idRegion = idRegion ;
        this.nombre = nombre ;
        this.direccion = direccion ;
        this.telefono = telefono ;
    }
    
    public Sucursal(int idSucursal, int idRegion, String nombre, String direccion, String telefono) {
        this.idSucursal = idSucursal ;
        this.idRegion = idRegion ;
        this.nombre = nombre ;
        this.direccion = direccion ;
        this.telefono = telefono ;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public JefeSucursal getJefeSucursal() {
        return jefeSucursal;
    }

    public Map<String, Producto> getProductos() {
        return productos;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.NOMBRE_VACIO.getTexto() );
        }else if(nombre.length() > 20){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_NOMBRE_20.getTexto() );
        }
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        if(direccion == null || direccion.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.DIRECCION_VACIO.getTexto() );
        }else if(direccion.length() > 20){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_DIRECCION_20.getTexto() );
        }
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        if(telefono == null || telefono.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.TELEFONO_VACIO.getTexto() );
        }else{
            try {
                int telefonoAux = Integer.parseInt(telefono);
                if(telefono.length() != 8){
                    throw new NumeroRangoException( TextoErrores.TELEFONO_RANGO.getTexto() );
                }
            } catch (NumberFormatException e){
                throw new NumeroFormatException( TextoErrores.TELEFONO_INVALIDO.getTexto() );
            }
        }
        this.telefono = telefono;
    }

    public void setJefeSucursal(JefeSucursal jefeSucursal) {
        this.jefeSucursal = jefeSucursal;
    }
    
    public void setProductos(Map<String, Producto> productos) {
        this.productos = productos;
    }
    
    //METODOS
    public boolean verificarExistenciaJefe(){
        return jefeSucursal != null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sucursal{idSucursal=").append(idSucursal);
        sb.append(", idRegion=").append(idRegion);
        sb.append(", nombre=").append(nombre);
        sb.append(", direccion=").append(direccion);
        sb.append(", telefono=").append(telefono);
        sb.append(", jefeSucursal=").append(jefeSucursal);
        sb.append('}');
        return sb.toString();
    }
}
