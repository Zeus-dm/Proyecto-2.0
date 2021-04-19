
package FunGenerales;

import domain.Sistema;
import domain.Usuario;
import enumeraciones.TextoErrores;
import excepciones.*;
import java.sql.SQLException;
import jdbc.JdbcUsuario;

public class FunUsuario {
    /**
     * Esta funcion crea un Usuario y lo inserta en la base de datos
     * @param sistema Insertamos el usuario al programa
     * @param nombre Nombre de usuario
     * @param password Contraseña del usuario
     * @param verPassword Segunda contraseña para verificar
     * @return Retorna un String de algun error, o null si todo esta correcto
     * @throws SQLException 
     */
    public static String agregarUsuario(Sistema sistema, String nombre, String password, String verPassword) throws SQLException{
        JdbcUsuario ju = new JdbcUsuario();
        Usuario usuario = ju.select(nombre);
        
        if(usuario != null){
            return TextoErrores.USUARIO_EXISTENTE.getTexto();
        }else if( !(password.equals(verPassword)) ){
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
        
        sistema.setUsuario(newUsuario);
        
        return null;
    }
    
    /**
     * Esta funcion verifica los datos e inicia sesion
     * @param sistema Insertamos el usuario al programa
     * @param nombre Nombre de usuario
     * @param password Contraseña del usuario
     * @return Retorna un String de error o null en caso de estar correcto
     * @throws SQLException 
     */
    public static String iniciarSesion(Sistema sistema, String nombre, String password) throws SQLException{
        JdbcUsuario ju = new JdbcUsuario();
        Usuario usuario = ju.select(nombre);
        
        if(usuario == null){
            return TextoErrores.USUARIO_PASSWORD_INCORRECTOS.getTexto();
        }else if( !(password.equals(usuario.getPassword())) ){
            return TextoErrores.USUARIO_PASSWORD_INCORRECTOS.getTexto();
        }
        
        sistema.setUsuario(usuario);
        
        return null;
    }
    
    /**
     * Esta funcion obtiene el nombre del usuario del sistema
     * @param sistema Obtenemos el usuario del sistema
     * @return Retorna el usuario si existe, o de lo contrario retorna null 
     */
    public static String seleccionarNombreUsuario(Sistema sistema) {
        return sistema.getUsuario().getNombre();
    }
    
    public static void eliminarUsuario(Sistema sistema){
        sistema.eliminarUsuario();
    }
    
    public static boolean existenciaUsuario(Sistema sistema){
        return sistema.verificarExistenciaUsuario();
    }
}
