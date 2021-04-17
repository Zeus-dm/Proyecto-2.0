
package domain;

import enumeraciones.TextoErrores;
import excepciones.*;

public class JefeSucursal extends Persona implements IGenerico{
    private int idJefe ;
    private int idSucursal ;
    
    public JefeSucursal() {   
    }
    
    public JefeSucursal(int idSucursal) {
        this.idSucursal = idSucursal ;
    }
    
    public JefeSucursal(String nombre, int edad, int idSucursal) {
        super(nombre, edad);
        this.idSucursal = idSucursal ;
    }
    
    public JefeSucursal(int idJefe, String nombre, int edad, int idSucursal) {
        super(nombre, edad);
        this.idJefe = idJefe ;
        this.idSucursal = idSucursal ;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public int getIdSucursal() {
        return idSucursal;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public int getEdad() {
        return edad;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    @Override
    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.NOMBRE_VACIO.getTexto() );
        }else if(nombre.length() > 40){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_NOMBRE_40.getTexto() );
        }
        this.nombre = nombre;
    }
    
    @Override
    public void setEdad(int edad) {
        if(edad < 18 || edad > 150){
            throw new NumeroRangoException( TextoErrores.EDAD_NO_RANGO.getTexto() );
        }
        this.edad = edad;
    }
    
    public void setEdad(String edad) {
        if(edad == null || edad.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.EDAD_VACIO.getTexto() );
        }else{
            try {
                int edadAux = Integer.parseInt(edad);
                if(edadAux < 18 || edadAux > 150){
                    throw new NumeroRangoException( TextoErrores.EDAD_NO_RANGO.getTexto() );
                }
                this.edad = edadAux;
            } catch (NumberFormatException e){
                throw new NumeroFormatException( TextoErrores.EDAD_NO_NUMERO.getTexto() );
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JefeSucursal{idJefe=").append(idJefe);
        sb.append(", idSucursal=").append(idSucursal);
        sb.append(", nombre=").append(this.getNombre());
        sb.append(", edad=").append(this.getEdad());
        sb.append('}');
        return sb.toString();
    }
}
