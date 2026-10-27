package icc.Practica.gestionpedidos;

public class FabricaDigital extends FabricaPedido {

    @Override
    public Pedido crearPedido(String codigo, String cliente, double subtotal) {
        return new PedidoDigital(codigo, cliente, subtotal);
    }
}
