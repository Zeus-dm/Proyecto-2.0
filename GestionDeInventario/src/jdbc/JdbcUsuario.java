
package jdbc;

import domain.IGenerico;
import domain.Usuario;
import java.sql.*;

public class JdbcUsuario implements IGenericoInsert{
    private Connection userConn;
    
    private static final String SQL_INSERT = "INSERT INTO gestion_inventario.usuario(nombre, password) VALUES(?, ?)";
    private static final String SQL_ONE_SELECT = "SELECT * FROM gestion_inventario.usuario WHERE nombre = ?";

    public JdbcUsuario() {
    }

    public JdbcUsuario(Connection userConn) {
        this.userConn = userConn;
    }
    
    //METODOS
    @Override
    public void insert(IGenerico generico) throws SQLException {
        Usuario usuario = (Usuario)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPassword());
            ps.executeUpdate();
        }finally{
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
    }
    
    public Usuario select(String nombre) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Usuario usuario = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_ONE_SELECT);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int idUsuario = rs.getInt("id_usuario");
                nombre = rs.getString("nombre");
                String password = rs.getString("password");

                usuario = new Usuario(idUsuario, nombre, password);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return usuario;
    }    
}
