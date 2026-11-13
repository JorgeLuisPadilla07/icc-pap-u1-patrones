package icc.comportamiento.state2;

public class Pagado implements EstadoPedido{

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Ya esta pagado");
    }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("Pedido enviado");
        pedido.changeState(new Enviado());
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("Debe enviarse primero");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("No se puede cancelar un pedido pagado");
    }

    @Override
    public String nombre() {
        return "Pagado";
    }
    
}
