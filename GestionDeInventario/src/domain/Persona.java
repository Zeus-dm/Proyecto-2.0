
package domain;

public abstract class Persona implements IGenerico{
    protected int id ; 
    protected String nombre ;
    protected int edad ;
    
    public Persona(){   
    }
    
    public Persona(int id){   
        this.id = id ;
    }
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre ;
        this.edad = edad ;
    }
    
    public Persona(int id, String nombre, int edad) {
        this.id = id ;
        this.nombre = nombre ;
        this.edad = edad ;
    }
    
    public abstract int getId();
    
    public abstract String getNombre();

    public abstract int getEdad();
    
    public abstract void setId(int id);

    public abstract void setNombre(String nombre);

    public abstract void setEdad(int edad);
}