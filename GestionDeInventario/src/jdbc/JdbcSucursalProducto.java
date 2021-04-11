
package jdbc;

import domain.IGenerico;
import domain.SucursalProducto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcSucursalProducto implements IGenericoInsert, IGenericoUpdate, IGenericoDelete{
    private Connection userConn;
    
    private static final String SQL_INSERT = "INSERT INTO gestion_inventario.sucursal_producto(id_producto, id_sucursal, stock) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE gestion_inventario.sucursal_producto SET id_producto = ?, id_sucursal = ?, stock = ? WHERE id_sucursal_producto = ?";
    private static final String SQL_DELETE = "DELETE FROM gestion_inventario.sucursal_producto WHERE id_sucursal_producto = ?";
    private static final String SQL_ONE_SELECT = "SELECT * FROM gestion_inventario.sucursal_producto WHERE id_producto = ? AND id_sucursal = ?";
    private static final String SQL_PRODUCTO_SELECT = "SELECT * FROM gestion_inventario.sucursal_producto WHERE id_producto = ?";
    private static final String SQL_SUCURSAL_SELECT = "SELECT * FROM gestion_inventario.sucursal_producto WHERE id_sucursal = ?";

    public JdbcSucursalProducto() {
    }

    public JdbcSucursalProducto(Connection userConn) {
        this.userConn = userConn;
    }
    
    //METODOS
    @Override
    public void insert(IGenerico generico) throws SQLException {
        SucursalProducto sp = (SucursalProducto)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, sp.getIdProducto());
            ps.setInt(2, sp.getIdSucursal());
            ps.setInt(3, sp.getStock());
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
        SucursalProducto sp = (SucursalProducto)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, sp.getIdProducto());
            ps.setInt(2, sp.getIdSucursal());
            ps.setInt(3, sp.getStock());
            ps.setInt(4, sp.getIdSP());
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
        SucursalProducto sp = (SucursalProducto)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, sp.getIdSP());
            ps.executeUpdate();
        }finally{
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
    }
    
    public IGenerico select(int idProducto, int idSucursal) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        SucursalProducto sp = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_ONE_SELECT);
            ps.setInt(1, idProducto);
            ps.setInt(2, idSucursal);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int idSP = rs.getInt("id_sucursal_producto");
                int newIdProducto = rs.getInt("id_producto");
                int newIdSucursal = rs.getInt("id_sucursal");
                int stock = rs.getInt("stock");
                
                sp = new SucursalProducto(idSP, newIdProducto, newIdSucursal, stock);  
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return sp;
    }
    
    public List<IGenerico> selectP(int idProducto) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<IGenerico> listaSucursalProductos = new ArrayList<>();
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_PRODUCTO_SELECT);
            ps.setInt(1, idProducto);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int idSP = rs.getInt("id_sucursal_producto");
                int newIdProducto = rs.getInt("id_producto");
                int newIdSucursal = rs.getInt("id_sucursal");
                int stock = rs.getInt("stock");
                
                SucursalProducto sp = new SucursalProducto(idSP, newIdProducto, newIdSucursal, stock);  
                listaSucursalProductos.add(sp);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return listaSucursalProductos;
    }
    
    public List<IGenerico> selectS(int idSucursal) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<IGenerico> listaSucursalProductos = new ArrayList<>();
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SUCURSAL_SELECT);
            ps.setInt(1, idSucursal);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int idSP = rs.getInt("id_sucursal_producto");
                int newIdProducto = rs.getInt("id_producto");
                int newIdSucursal = rs.getInt("id_sucursal");
                int stock = rs.getInt("stock");
                
                SucursalProducto sp = new SucursalProducto(idSP, newIdProducto, newIdSucursal, stock);  
                listaSucursalProductos.add(sp);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return listaSucursalProductos;
    }
}