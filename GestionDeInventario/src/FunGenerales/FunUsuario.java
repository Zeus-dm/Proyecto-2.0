
package FunGenerales;

import domain.Usuario;
import enumeraciones.TextoErrores;
import excepciones.*;
import java.sql.SQLException;
import jdbc.JdbcUsuario;

public class FunUsuario {
    /**
     * Esta funcion crea un Usuario y lo inserta en la base de datos
     * @param nombre Nombre de usuario
     * @param password Contraseña del usuario
     * @param verPassword Segunda contraseña para verificar
     * @return Retorna un String de algun error, o null si todo esta correcto
     * @throws SQLException 
     */
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
    
    /**
     * Esta funcion verifica los datos e inicia sesion
     * @param nombre Nombre de usuario
     * @param password Contraseña del usuario
     * @return Retorna un String de error o null en caso de estar correcto
     * @throws SQLException 
     */
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
    
    /**
     * Esta funcion obtiene un usuario de la base de datos por el nombre de usuario
     * @param nombre Nombre de usuario
     * @return Retorna el usuario si existe, o de lo contrario retorna null
     * @throws SQLException 
     */
    public static Usuario seleccionarUsuario(String nombre) throws SQLException{
        JdbcUsuario ju = new JdbcUsuario();
        Usuario usuario = ju.select(nombre);
        
        return usuario;
    }
}
