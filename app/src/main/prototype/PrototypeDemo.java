package icc.pap.u1.patrones.prototype;

public class PrototypeDemo implements Cloneable {

    // atributos
    private String nombre;
    private int edad;

    // Constructor
    public PrototypeDemo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    // getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Metodo principal del patron nos permite clonar la instancia

    @Override

    public PrototypeDemo clone() {
        try {
            return (PrototypeDemo) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
