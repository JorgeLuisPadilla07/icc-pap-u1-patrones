package icc.comportamiento.state2;

public class Pedido {

    private EstadoPedido estado = new Pendiente();
    
    public void changeState(EstadoPedido nuevo) {
        this.estado = nuevo;
    }

    public void pagar(){
        estado.pagar(this);
    }

    public void enviar(){
        estado.enviar(this);
    }

    public void entregar(){
        estado.entregar(this);
    }

    public void cancelar(){
        estado.cancelar(this);
    }

    public String getState(){
        return estado.nombre();
    }

}
