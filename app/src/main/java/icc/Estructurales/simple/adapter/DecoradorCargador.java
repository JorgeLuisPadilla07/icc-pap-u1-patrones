package icc.Estructurales.simple.adapter;

public abstract class DecoradorCargador implements Cargador {

protected Cargador cargador;

public DecoradorCargador(Cargador cargador) {
    this.cargador = cargador;
}

@Override
public void cargarCelular() {
    cargador.cargarCelular();
}

}