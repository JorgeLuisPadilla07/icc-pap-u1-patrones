package icc.Estructurales.simple.adapter;

public class DecoradorRegistro extends DecoradorCargador {

public DecoradorRegistro(Cargador cargador) {
    super(cargador);
}

@Override
public void cargarCelular() {
    System.out.println("Iniciando carga...");
    super.cargarCelular();
    System.out.println("Carga finalizada.");
}

}