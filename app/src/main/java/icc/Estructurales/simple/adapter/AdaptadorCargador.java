package icc.Estructurales.simple.adapter;

public class AdaptadorCargador implements Cargador {

private final CargadorAntiguo cargadorAntiguo;

public AdaptadorCargador(CargadorAntiguo cargadorAntiguo) {
    this.cargadorAntiguo = cargadorAntiguo;
}

@Override
public void cargarCelular() {
    cargadorAntiguo.cargarConector();
}

}
