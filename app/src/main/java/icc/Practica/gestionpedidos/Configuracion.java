package icc.Practica.gestionpedidos;

/**
 * PATRÓN 1: SINGLETON
 * Solo puede existir UN objeto de esta clase en todo el programa.
 * Guarda el porcentaje de impuesto que usan todos los pedidos.
 */
public class Configuracion {

    // Se crea una sola vez, apenas se carga la clase
    private static final Configuracion instancia = new Configuracion();

    private double impuesto = 15.0;

    // Constructor privado: nadie fuera puede hacer "new Configuracion()"
    private Configuracion() {
    }

    // Única forma de obtener la configuración
    public static Configuracion getInstancia() {
        return instancia;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
}
