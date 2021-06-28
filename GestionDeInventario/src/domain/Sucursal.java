
package domain;

import enumeraciones.TextoErrores;
import excepciones.*;
import java.util.List;

public class Sucursal implements IGenerico{
    private int idSucursal ;
    private int idRegion ;
    private String nombre ;
    private String direccion ;
    private String telefono ;
    private JefeSucursal jefeSucursal = null;
    private final CollectionProductos productos;
    
    public Sucursal() {     
        productos = new CollectionProductos();
    }
    
    public Sucursal(int idSucursal) {
        this.idSucursal = idSucursal ;
        productos = new CollectionProductos();
    }
    
    public Sucursal(int idRegion, String nombre, String direccion, String telefono) {
        this.idRegion = idRegion ;
        this.nombre = nombre ;
        this.direccion = direccion ;
        this.telefono = telefono ;
        productos = new CollectionProductos();
    }
    
    public Sucursal(int idSucursal, int idRegion, String nombre, String direccion, String telefono) {
        this.idSucursal = idSucursal ;
        this.idRegion = idRegion ;
        this.nombre = nombre ;
        this.direccion = direccion ;
        this.telefono = telefono ;
        productos = new CollectionProductos();
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public JefeSucursal getJefeSucursal() {
        return jefeSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.NOMBRE_VACIO.getTexto() );
        }else if(nombre.length() > 20){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_NOMBRE_20.getTexto() );
        }
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        if(direccion == null || direccion.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.DIRECCION_VACIO.getTexto() );
        }else if(direccion.length() > 20){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_DIRECCION_20.getTexto() );
        }
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        if(telefono == null || telefono.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.TELEFONO_VACIO.getTexto() );
        }else{
            try {
                int telefonoAux = Integer.parseInt(telefono);
                if(telefono.length() != 8){
                    throw new NumeroRangoException( TextoErrores.TELEFONO_RANGO.getTexto() );
                }
            } catch (NumberFormatException e){
                throw new NumeroFormatException( TextoErrores.TELEFONO_INVALIDO.getTexto() );
            }
        }
        this.telefono = telefono;
    }

    public void setJefeSucursal(JefeSucursal jefeSucursal) {
        this.jefeSucursal = jefeSucursal;
    }
    
    //METODOS
    public boolean verificarExistenciaJefe(){
        return jefeSucursal != null;
    }
    
    //Productos
    public boolean verificarExistenciaProducto(String barCode){
        return productos.verificarExistencia(barCode);
    }
    
    public Producto obtenerProducto(String barCode){
        return productos.obtenerProducto(barCode);
    }
    
    public void agregarProducto(Producto producto){
        productos.agregarProducto(producto);
    }
    
    public void eliminarProducto(String barCode){
        productos.eliminarProducto(barCode);
    }
    
    public void modificarProducto(String preBarCode, Producto nuevoProducto){
        productos.modificarProducto(preBarCode, nuevoProducto);
    }
    
    public List<String> todosProductos(){
        return productos.todosProductos();
    }
    
    public List<String> todosBarCodes(){
        return productos.todosBarCodes();
    }
    
    public List<String> productosFiltrados(){
        return productos.productosFiltrados();
    }

    public List<String> filtrarProductos(int min, int max, String textoBuscar){
        return productos.menuFiltrado(min, max, textoBuscar);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sucursal{idSucursal=").append(idSucursal);
        sb.append(", idRegion=").append(idRegion);
        sb.append(", nombre=").append(nombre);
        sb.append(", direccion=").append(direccion);
        sb.append(", telefono=").append(telefono);
        sb.append(", jefeSucursal=").append(jefeSucursal);
        sb.append('}');
        return sb.toString();
    }
}
