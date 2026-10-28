package icc.Estructurales.simple.adapter;

public class AdaptadorCargador implements Cargador {
    

    //dependencia del cargador(antiguo)
    private final CargadorAntiguo cargadorAntiguo;


    public AdaptadorCargador() {
        this.cargadorAntiguo = new CargadorAntiguo();
    }

    @Override
    public void cargarCelular() {
        cargadorAntiguo.cargarConector();
    }
    
}
