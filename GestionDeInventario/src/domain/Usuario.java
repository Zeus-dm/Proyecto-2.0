
package domain;

import enumeraciones.TextoErrores;
import excepciones.*;

public class Usuario implements IGenerico{
    private int idUsuario;
    private String nombre;
    private String password;

    public Usuario() {
    }

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public Usuario(int idUsuario, String nombre, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.USUARIO_VACIO.getTexto() );
        }else if(nombre.length() > 20){
            throw new TextoTamanoMaximoException( TextoErrores.USUARIO_MAXIMO_CARACTERES_20.getTexto() );
        }
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        if(password == null || password.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.PASSWORD_VACIO.getTexto() );
        }else if(password.length() > 20){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_PASSWORD_20.getTexto() );
        }
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{idUsuario=").append(idUsuario);
        sb.append(", nombre=").append(nombre);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }
}
