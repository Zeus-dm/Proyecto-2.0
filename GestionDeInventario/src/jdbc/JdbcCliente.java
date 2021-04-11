
package jdbc;

import domain.Cliente;
import domain.IGenerico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCliente implements IGenericoInsert, IGenericoUpdate, IGenericoDelete, IGenericoSelect, IGenericoSelectList{
    private Connection userConn;
    
    private static final String SQL_INSERT = "INSERT INTO gestion_inventario.cliente(nombre, edad, direccion, telefono, email) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE gestion_inventario.cliente SET nombre = ?, edad = ?, direccion = ?, telefono = ?, email = ? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM gestion_inventario.cliente WHERE id_cliente = ?";
    private static final String SQL_SELECT = "SELECT * FROM gestion_inventario.cliente";
    private static final String SQL_ONE_SELECT = "SELECT * FROM gestion_inventario.cliente WHERE id_cliente = ?";
    
    public JdbcCliente() {
    }

    public JdbcCliente(Connection userConn) {
        this.userConn = userConn;
    }
    
    //METODOS
    @Override
    public void insert(IGenerico generico) throws SQLException {
        Cliente cliente = (Cliente)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, cliente.getNombre());
            ps.setInt(2, cliente.getEdad());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEmail());
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
        Cliente cliente = (Cliente)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, cliente.getNombre());
            ps.setInt(2, cliente.getEdad());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEmail());
            ps.setInt(6, cliente.getIdCliente());
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
        Cliente cliente = (Cliente)generico;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();
        }finally{
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
    }

    @Override
    public IGenerico select(int idCliente) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Cliente cliente = null;
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_ONE_SELECT);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int newIdCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                cliente = new Cliente(newIdCliente, nombre, edad, direccion, telefono, email);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return cliente;
    }

    @Override
    public List<IGenerico> select() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<IGenerico> listaClientes = new ArrayList<>();
        
        try{
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                Cliente cliente = new Cliente(idCliente, nombre, edad, direccion, telefono, email);
                listaClientes.add(cliente);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        
        return listaClientes;
    }
}