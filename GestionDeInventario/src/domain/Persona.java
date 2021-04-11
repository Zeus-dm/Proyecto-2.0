
package domain;

public abstract class Persona {
    protected String nombre ;
    protected int edad ;
    
    public Persona(){   
    }
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre ;
        this.edad = edad ;
    }

    public abstract String getNombre();

    public abstract int getEdad();

    public abstract void setNombre(String nombre);

    public abstract void setEdad(int edad);
}
