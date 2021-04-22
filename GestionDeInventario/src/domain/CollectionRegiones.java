
package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionRegiones {
    private final List<Region> listaRegiones;
    private final List<String> nombresRegiones;
    private final Map<String,Region> mapaRegiones;

    public CollectionRegiones() {
        listaRegiones = new ArrayList<>();
        nombresRegiones = new ArrayList<>();
        mapaRegiones = new HashMap<>();
    }
    
    //METODOS
    public boolean verificarExistencia(String nombre){
        Region region = mapaRegiones.get(nombre.toUpperCase());
        return region != null;
    }
    
    public Region obtenerRegion(String nombre){
        return mapaRegiones.get(nombre.toUpperCase());
    }
    
    public void agregarRegion(Region region){
        listaRegiones.add(region);
        nombresRegiones.add(region.getNombre());
        mapaRegiones.put(region.getNombre().toUpperCase(), region);
    }
    
    public void eliminarRegion(String nombre){
        for (int i = 0; i < listaRegiones.size(); i++) {
            if(nombre.equals(listaRegiones.get(i).getNombre())){
                listaRegiones.remove(i);
                nombresRegiones.remove(i);
                break;
            }
        }
        
        mapaRegiones.remove(nombre.toUpperCase());
    }
    
    public void modificarRegion(String preNombre, Region nuevaRegion){
        for (int i = 0; i < listaRegiones.size(); i++) {
            if(preNombre.equalsIgnoreCase(listaRegiones.get(i).getNombre())){
                listaRegiones.set(i, nuevaRegion);
                nombresRegiones.set(i, nuevaRegion.getNombre());
                break;
            }
        }
        
        mapaRegiones.remove(preNombre.toUpperCase());
        mapaRegiones.put(nuevaRegion.getNombre().toUpperCase(), nuevaRegion);
    }
    
    public List<String> obtenerNombres(){
        return nombresRegiones;
    }
}
