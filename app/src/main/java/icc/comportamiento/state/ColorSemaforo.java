package icc.comportamiento.state;

public enum ColorSemaforo {
    ROJO("Rojo"),
    VERDE("Verde"),
    AMARILLO("Amarillo");

    final String color;
    public ColorSemaforo siguiente;

    private ColorSemaforo (String color) {
        this.color = color;
    }

    static {
        ROJO.siguiente = VERDE;
        VERDE.siguiente = AMARILLO;
        AMARILLO.siguiente = ROJO;
    }
}
