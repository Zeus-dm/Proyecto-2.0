
package domain;

import enumeraciones.TextoErrores;
import excepciones.*;
import java.util.ArrayList;
import java.util.List;

public class Region implements IGenerico{
    private int idRegion;
    private String nombre;
    List<Sucursal> sucursales = new ArrayList<>();

    public Region() {
    }

    public Region(int idRegion) {
        this.idRegion = idRegion;
    }

    public Region(String nombre) {
        this.nombre = nombre;
    }

    public Region(int idRegion, String nombre) {
        this.idRegion = idRegion;
        this.nombre = nombre;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.NOMBRE_VACIO.getTexto() );
        }else if(nombre.length() > 20){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_NOMBRE_20.getTexto() );
        }
        this.nombre = nombre;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
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
