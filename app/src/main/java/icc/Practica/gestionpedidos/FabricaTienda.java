package icc.Practica.gestionpedidos;

public class FabricaTienda extends FabricaPedido {

    @Override
    public Pedido crearPedido(String codigo, String cliente, double subtotal) {
        return new PedidoTienda(codigo, cliente, subtotal);
    }
}
