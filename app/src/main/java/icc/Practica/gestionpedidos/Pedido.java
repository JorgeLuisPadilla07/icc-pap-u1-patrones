package icc.Practica.gestionpedidos;

/**
 * Clase base de todos los pedidos.
 * Tiene los datos comunes y calcula el total con el impuesto.
 * Cada tipo de pedido decide cómo generar su comprobante.
 */
public abstract class Pedido {

    private String codigo;
    private String cliente;
    private double subtotal;

    public Pedido(String codigo, String cliente, double subtotal) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.subtotal = subtotal;
    }

    public double calcularImpuesto() {
        // Usa la configuración compartida (Singleton)
        double porcentaje = Configuracion.getInstancia().getImpuesto();
        return subtotal * porcentaje / 100;
    }

    public double calcularTotal() {
        return subtotal + calcularImpuesto();
    }

    public void procesar() {
        System.out.println("Código: " + codigo);
        System.out.println("Cliente: " + cliente);
        System.out.printf("Subtotal: ", subtotal);
        System.out.printf("Impuesto: ", calcularImpuesto());
        System.out.printf("Total: ", calcularTotal());
        generarComprobante();
    }

    // Cada hijo lo implementa a su manera
    protected abstract void generarComprobante();
}
