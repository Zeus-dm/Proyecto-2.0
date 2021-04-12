
package domain;

import excepciones.*;
import enumeraciones.TextoErrores;

public class Cliente extends Persona implements IGenerico{
    private int idCliente ;
    private String direccion ;
    private String telefono ;
    private String email ;
    
    public Cliente () {    
    }
    
    public Cliente (int idCliente) {
        this.idCliente = idCliente ;
    }
    
    public Cliente (String nombre, int edad, String direccion, String telefono, String email) {
        super(nombre, edad);
        this.direccion = direccion ;
        this.telefono = telefono ;
        this.email = email ;
    }
    
    public Cliente (int idCliente, String nombre, int edad, String direccion, String telefono, String email) {
        super(nombre, edad);
        this.idCliente = idCliente ;
        this.direccion = direccion ;
        this.telefono = telefono ;
        this.email = email ;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public int getEdad() {
        return edad;
    }

    public void setDireccion(String direccion) {
        if(direccion == null || direccion.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.DIRECCION_VACIO.getTexto() );
        }else if(direccion.length() > 20){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES.getTexto() );
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

    public void setEmail(String email) {
        if(email == null || email.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.EMAIL_VACIO.getTexto() );
        }else if(email.length() > 40){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_40.getTexto() );
        }else{
            String cadena[] = email.split("@") ;
            if (cadena.length != 2){
                throw new TextoEmailException( TextoErrores.EMAIL_INVALIDO.getTexto() );
            }else if(cadena[0] == null || cadena[0].isEmpty() || cadena[1] == null || cadena[1].isEmpty()) {
                throw new TextoEmailException( TextoErrores.EMAIL_INVALIDO.getTexto() );
            }else if(!cadena[1].contains(".") || '.' == email.charAt(email.length()-1)) {
                throw new TextoEmailException( TextoErrores.EMAIL_INVALIDO.getTexto() );
            }
        }
        this.email = email;
    }
    
    @Override
    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.NOMBRE_VACIO.getTexto() );
        }else if(nombre.length() > 40){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_40.getTexto() );
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
        sb.append("Cliente{idCliente=").append(idCliente);
        sb.append(", direccion=").append(direccion);
        sb.append(", telefono=").append(telefono);
        sb.append(", email=").append(email);
        sb.append(", nombre=").append(this.getNombre());
        sb.append(", edad=").append(this.getEdad());
        sb.append('}');
        return sb.toString();
    }
}
