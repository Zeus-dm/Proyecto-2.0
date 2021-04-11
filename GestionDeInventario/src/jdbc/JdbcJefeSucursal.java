
package jdbc;

import domain.IGenerico;
import domain.JefeSucursal;
import java.sql.*;

public class JdbcJefeSucursal implements IGenericoInsert, IGenericoUpdate, IGenericoDelete, IGenericoSelect{
    private Connection userConn;
    
    private static final String SQL_INSERT = "INSERT INTO gestion_inventario.jefe_sucursal(id_sucursal, nombre, edad) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE gestion_inventario.jefe_sucursal SET nombre = ?, edad = ? WHERE id_sucursal = ?";
    private static final String SQL_DELETE = "DELETE FROM gestion_inventario.jefe_sucursal WHERE id_sucursal = ?";
    private static final String SQL_ONE_SELECT = "SELECT * FROM gestion_inventario.jefe_sucursal WHERE id_sucursal = ?";

    public JdbcJefeSucursal() {
    }

    public JdbcJefeSucursal(Connection userConn) {
        this.userConn = userConn;
    }
    
    //METODOS
    @Override
    public void insert(IGenerico generico) throws SQLException {
        JefeSucursal jefe = (JefeSucursal)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, jefe.getIdSucursal());
            ps.setString(2, jefe.getNombre());
            ps.setInt(3, jefe.getEdad());
            ps.executeUpdate();
        }finally{
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
    }

    @Override
    public void update(IGenerico generico) throws SQLException {
        JefeSucursal jefe = (JefeSucursal)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, jefe.getNombre());
            ps.setInt(2, jefe.getEdad());
            ps.setInt(3, jefe.getIdSucursal());
            ps.executeUpdate();
        }finally{
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
    }

    @Override
    public void delete(IGenerico generico) throws SQLException {
        JefeSucursal jefe = (JefeSucursal)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, jefe.getIdSucursal());
            ps.executeUpdate();
        }finally{
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
    }

    @Override
    public IGenerico select(int idSucursal) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        JefeSucursal jefeSucursal = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_ONE_SELECT);
            ps.setInt(1, idSucursal);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int idJefeSucursal = rs.getInt("id_jefe_sucursal");
                int newIdSucursal = rs.getInt("id_sucursal");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                
                jefeSucursal = new JefeSucursal(idJefeSucursal, nombre, edad, newIdSucursal);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return jefeSucursal;
    }
}