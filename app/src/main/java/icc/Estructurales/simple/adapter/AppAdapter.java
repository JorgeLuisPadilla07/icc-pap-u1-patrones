package icc.Estructurales.simple.adapter;
/**
 * 
 * Adapter: permite usar un termometro Fahrenheit con una aplicación que espera un termometro Celsius.
 */
public final class AppAdapter {
    public static void main(String[] args) {
        // CARGAR MI CELULAR CON UN CARGADOR
        // PERO COMO AHORA TENGO UN CA DEBO CREAR UN ADAPTADOR
        CargadorAntiguo cAntiguo = new CargadorAntiguo();
        CargadorInalambrico cInalambrico = new CargadorInalambrico();

        Cargador cargor1 = new AdaptadorCargador();
        Cargador cargor2 = new AdaptadorCargadorIna();
        // CARGAR EL CELULAR
        cargor1.cargarCelular();
        cargor2.cargarCelular();

        // CARGAR EL CELULAR - SIN EL PATRON
        // SI EL CARGADOR ES ANTIGUO

        cAntiguo.cargarConector();

        cInalambrico.cargarBase();
    }
}
