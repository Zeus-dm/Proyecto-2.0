
package jdbc;

import domain.IGenerico;
import domain.Sucursal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcSucursal implements IGenericoInsert, IGenericoUpdate, IGenericoDelete, IGenericoSelect{
    private Connection userConn;
    
    private static final String SQL_INSERT = "INSERT INTO gestion_inventario.sucursal(id_region, nombre, direccion, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE gestion_inventario.sucursal SET id_region = ?, nombre = ?, direccion = ?, telefono = ? WHERE id_sucursal = ?";
    private static final String SQL_DELETE = "DELETE FROM gestion_inventario.sucursal WHERE id_sucursal = ?";
    private static final String SQL_SELECT = "SELECT * FROM gestion_inventario.sucursal WHERE id_region = ?";
    private static final String SQL_ONE_SELECT = "SELECT * FROM gestion_inventario.sucursal WHERE id_sucursal = ?";

    public JdbcSucursal() {
    }

    public JdbcSucursal(Connection userConn) {
        this.userConn = userConn;
    }
    
    //METODOS
    @Override
    public void insert(IGenerico generico) throws SQLException {
        Sucursal sucursal = (Sucursal)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, sucursal.getIdRegion());
            ps.setString(2, sucursal.getNombre());
            ps.setString(3, sucursal.getDireccion());
            ps.setString(4, sucursal.getTelefono());
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
        Sucursal sucursal = (Sucursal)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, sucursal.getIdRegion());
            ps.setString(2, sucursal.getNombre());
            ps.setString(3, sucursal.getDireccion());
            ps.setString(4, sucursal.getTelefono());
            ps.setInt(5, sucursal.getIdSucursal());
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
        Sucursal sucursal = (Sucursal)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, sucursal.getIdSucursal());
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
        
        Sucursal sucursal = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_ONE_SELECT);
            ps.setInt(1, idSucursal);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int newIdSucursal = rs.getInt("id_sucursal");
                int idRegion = rs.getInt("id_region");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                sucursal = new Sucursal(newIdSucursal, idRegion, nombre, direccion, telefono);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return sucursal;
    }

    public List<IGenerico> selectList(int idRegion) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<IGenerico> listaSucursales = new ArrayList<>();
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, idRegion);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int idSucursal = rs.getInt("id_sucursal");
                idRegion = rs.getInt("id_region");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                
                Sucursal sucursal = new Sucursal(idSucursal, idRegion, nombre, direccion, telefono);
                listaSucursales.add(sucursal);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return listaSucursales;
    }
}