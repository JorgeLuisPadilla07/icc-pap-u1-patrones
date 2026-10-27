package icc.Practica.gestionpedidos;

/** Pedido hecho por la plataforma digital. */
public class PedidoDigital extends Pedido {

    public PedidoDigital(String codigo, String cliente, double subtotal) {
        super(codigo, cliente, subtotal);
    }

    @Override
    protected void generarComprobante() {
        System.out.println("Confirmación digital generada.");
    }
}
