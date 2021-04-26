
package jdbc;

import domain.IGenerico;
import domain.Region;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRegion implements IGenericoInsert, IGenericoUpdate, IGenericoDelete, IGenericoSelect, IGenericoSelectList{
    private Connection userConn;
    
    private static final String SQL_INSERT = "INSERT INTO gestion_inventario.region(nombre) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE gestion_inventario.region SET nombre = ? WHERE id_region = ?";
    private static final String SQL_DELETE = "DELETE FROM gestion_inventario.region WHERE id_region = ?";
    private static final String SQL_SELECT = "SELECT * FROM gestion_inventario.region";
    private static final String SQL_ONE_SELECT = "SELECT * FROM gestion_inventario.region WHERE id_region = ?";
    private static final String SQL_MAX_ID = "SELECT MAX(id_region) AS id_region FROM gestion_inventario.region";

    public JdbcRegion() {
    }

    public JdbcRegion(Connection userConn) {
        this.userConn = userConn;
    }
    
    //METODOS
    @Override
    public void insert(IGenerico generico) throws SQLException {
        Region region = (Region)generico;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, region.getNombre());
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
        Region region = (Region)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, region.getNombre());
            ps.setInt(2, region.getIdRegion());
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
        Region region = (Region)generico;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, region.getIdRegion());
            ps.executeUpdate();
        }finally{
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
    }

    @Override
    public IGenerico select(int idRegion) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Region region = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_ONE_SELECT);
            ps.setInt(1, idRegion);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int newIdRegion = rs.getInt("id_region");
                String nombre = rs.getString("nombre");
                
                region = new Region(newIdRegion, nombre);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return region;
    }

    @Override
    public List<IGenerico> select() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<IGenerico> listaRegiones = new ArrayList<>();
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int idRegion = rs.getInt("id_region");
                String nombre = rs.getString("nombre");
                
                Region region = new Region(idRegion, nombre);
                listaRegiones.add(region);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return listaRegiones;
    }
    
    public Integer ultimoId() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Integer maxId = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_MAX_ID);
            rs = ps.executeQuery();
            
            while(rs.next()){
                maxId = rs.getInt("id_region");
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return maxId;
    }
}
