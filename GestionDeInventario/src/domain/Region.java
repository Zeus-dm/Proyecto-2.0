
package domain;

import enumeraciones.TextoErrores;
import excepciones.*;
import java.util.List;

public class Region implements IGenerico{
    private int idRegion;
    private String nombre;
    private final CollectionSucursales sucursales;

    public Region() {
        sucursales = new CollectionSucursales();
    }

    public Region(int idRegion) {
        this.idRegion = idRegion;
        sucursales = new CollectionSucursales();
    }

    public Region(String nombre) {
        this.nombre = nombre;
        sucursales = new CollectionSucursales();
    }

    public Region(int idRegion, String nombre) {
        this.idRegion = idRegion;
        this.nombre = nombre;
        sucursales = new CollectionSucursales();
    }

    public int getIdRegion() {
        return idRegion;
    }

    public String getNombre() {
        return nombre;
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

    //METODOS
    public boolean verificarExistenciaSucursal(String nombre){
        return sucursales.verificarExistencia(nombre);
    }
    
    public Sucursal obtenerSucursal(String nombre){
        return sucursales.obtenerSucursal(nombre);
    }
    
    public void agregarSucursal(Sucursal sucursal){
        sucursales.agregarSucursal(sucursal);
    }
    
    public void eliminarSucursal(String nombre){
        sucursales.eliminarSucursal(nombre);
    }
    
    public void modificarSucursal(String preNombre, String newNombre){
        sucursales.modificarSucursal(preNombre, newNombre);
    }
    
    public List<String> nombresSucursales(){
        return sucursales.obtenerNombres();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Region{idRegion=").append(idRegion);
        sb.append(", nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
}
