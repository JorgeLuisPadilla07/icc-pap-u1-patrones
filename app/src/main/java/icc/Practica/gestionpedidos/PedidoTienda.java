package icc.Practica.gestionpedidos;

/** Pedido hecho directamente en la tienda. */
public class PedidoTienda extends Pedido {

    public PedidoTienda(String codigo, String cliente, double subtotal) {
        super(codigo, cliente, subtotal);
    }

    @Override
    protected void generarComprobante() {
        System.out.println("Comprobante generado en tienda.");
    }
}
