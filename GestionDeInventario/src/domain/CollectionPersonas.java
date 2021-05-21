
package domain;

import java.util.ArrayList;
import java.util.List;

public class CollectionPersonas {
    private final List<Persona> listaPersonas;
    private final List<String> nombresPersonas;
    private final List<Integer> idsPersonas;

    public CollectionPersonas() {
        listaPersonas = new ArrayList<>();
        nombresPersonas = new ArrayList<>();
        idsPersonas = new ArrayList<>();
    }
    
    //METODOS
    public Persona obtenerPersona(int idPersona){
        for (Persona persona : listaPersonas) {
            if(persona.getId() == idPersona){
                return persona;
            }
        }
        return null;
    }
    
    public void agregarPersona(Persona persona){
        listaPersonas.add(persona);
        nombresPersonas.add(persona.getNombre());
        idsPersonas.add(persona.getId());
    }
    
    public void eliminarPersona(int idPersona){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getId() == idPersona){
                listaPersonas.remove(i);
                nombresPersonas.remove(i);
                idsPersonas.remove(i);
                break;
            }
        }
    }
    
    public void modificarPersona(int idPersona, Persona nuevaPersona){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getId() == idPersona){
                listaPersonas.set(i, nuevaPersona);
                nombresPersonas.set(i, nuevaPersona.getNombre());
                idsPersonas.set(i, nuevaPersona.getId());
                break;
            }
        }
    }
    
    public List<String> obtenerNombres(){
        return nombresPersonas;
    }
    
    public List<Integer> obtenerIds(){
        return idsPersonas;
    }
}
