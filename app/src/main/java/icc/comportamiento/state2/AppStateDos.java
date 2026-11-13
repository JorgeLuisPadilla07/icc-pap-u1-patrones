package icc.comportamiento.state2;

public class AppStateDos {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        System.out.println(pedido.getState());
        pedido.entregar();
        pedido.pagar();
        System.out.println(pedido.getState());
        pedido.entregar();
        System.out.println(pedido.getState());
        pedido.cancelar();
        System.out.println(pedido.getState());
        pedido.entregar();
        System.out.println(pedido.getState());
    }
}
