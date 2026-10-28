package icc.Estructurales.simple.adapter;

public class AdaptadorCargadorIna implements Cargador {

private final CargadorInalambrico cInalambrico;

public AdaptadorCargadorIna(CargadorInalambrico cInalambrico) {
    this.cInalambrico = cInalambrico;
}

@Override
public void cargarCelular() {
    cInalambrico.cargarBase();
}

}