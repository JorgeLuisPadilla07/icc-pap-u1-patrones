package icc.Practica.gestionpedidos;

/**
 * PATRÓN 2: FACTORY METHOD
 * Define el método "crearPedido", que cada fábrica hija implementa
 * para devolver el tipo de pedido que le corresponde.
 * El resto del programa solo trabaja con "Pedido", sin saber cuál es.
 */
public abstract class FabricaPedido {

    // Método fábrica: lo implementan las clases hijas
    public abstract Pedido crearPedido(String codigo, String cliente, double subtotal);

    // Crea el pedido y lo procesa
    public Pedido registrarYProcesar(String codigo, String cliente, double subtotal) {
        Pedido pedido = crearPedido(codigo, cliente, subtotal);
        pedido.procesar();
        return pedido;
    }
}
