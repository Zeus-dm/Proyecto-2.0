
package domain;

import java.util.ArrayList;
import java.util.List;

public class CollectionSucursales {
    private final List<Sucursal> listaSucursales;
    private final List<String> nombresSucursales;

    public CollectionSucursales() {
        listaSucursales = new ArrayList<>();
        nombresSucursales = new ArrayList<>();
    }
    
    //METODOS
    public boolean verificarExistencia(String nombre){
        for (Sucursal sucursal : listaSucursales) {
            if(nombre.equalsIgnoreCase(sucursal.getNombre())){
                return true;
            }
        }
        return false;
    }
    
    public Sucursal obtenerSucursal(String nombre){
        for (Sucursal sucursal : listaSucursales) {
            if(nombre.equalsIgnoreCase(sucursal.getNombre())){
                return sucursal;
            }
        }
        return null;
    }
    
    public void agregarSucursal(Sucursal sucursal){
        listaSucursales.add(sucursal);
        nombresSucursales.add(sucursal.getNombre());
    }
    
    public void eliminarSucursal(String nombre){
        for (int i = 0; i < listaSucursales.size(); i++) {
            if(nombre.equalsIgnoreCase(listaSucursales.get(i).getNombre())){
                listaSucursales.remove(i);
                nombresSucursales.remove(i);
                break;
            }
        }
    }
    
    public void modificarSucursal(String preNombre, Sucursal nuevaSucursal){
        for (int i = 0; i < listaSucursales.size(); i++) {
            if(preNombre.equalsIgnoreCase(listaSucursales.get(i).getNombre())){
                listaSucursales.set(i, nuevaSucursal);
                nombresSucursales.set(i, nuevaSucursal.getNombre());
                break;
            }
        }
    }
    
    public List<String> obtenerNombres(){
        return nombresSucursales;
    }
}
