package icc.comportamiento.state;

public final class Semaforo {
    private ColorSemaforo estado;

    public Semaforo() {
        estado = ColorSemaforo.ROJO;
    }

    public String color() {
        return estado.color;
    }

    public void avanzar() {
        estado = estado.siguiente;
    }    
}
