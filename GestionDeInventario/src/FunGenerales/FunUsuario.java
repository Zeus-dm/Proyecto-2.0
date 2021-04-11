
package FunGenerales;

import domain.Usuario;
import enumeraciones.TextoErrores;
import excepciones.*;
import java.sql.SQLException;
import jdbc.JdbcUsuario;

public class FunUsuario {
    public static String agregarUsuario(String nombre, String password, String verPassword) throws SQLException{
        JdbcUsuario ju = new JdbcUsuario();
        Usuario usuario = ju.select(nombre);
        
        if(usuario != null){
            return TextoErrores.USUARIO_EXISTENTE.getTexto();
        }else if( !(password.equals(verPassword)) ){
            return TextoErrores.PASSWORD_DIFERENTES.getTexto();
        }else if( !(verPassword.equals(password)) ){
            return TextoErrores.PASSWORD_DIFERENTES.getTexto();
        }
        
        Usuario newUsuario = new Usuario();
        try {
            newUsuario.setNombre(nombre);
            newUsuario.setPassword(password);
        } catch (TextoEnBlancoException | TextoTamanoMaximoException e){
            return e.getMessage();
        }
        
        ju.insert(newUsuario);
        
        return null;
    }
    
    public static String iniciarSesion(String nombre, String password) throws SQLException{
        JdbcUsuario ju = new JdbcUsuario();
        Usuario usuario = ju.select(nombre);
        
        if(usuario == null){
            return TextoErrores.USUARIO_PASSWORD_INCORRECTOS.getTexto();
        }else if( !(password.equals(usuario.getPassword())) ){
            return TextoErrores.USUARIO_PASSWORD_INCORRECTOS.getTexto();
        }
        
        return null;
    }
    
    public static Usuario seleccionarUsuario(String nombre) throws SQLException{
        JdbcUsuario ju = new JdbcUsuario();
        Usuario usuario = ju.select(nombre);
        
        return usuario;
    }
}
