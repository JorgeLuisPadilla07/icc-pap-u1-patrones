package icc.Estructurales.simple.adapter;
/**
 * 
 * Adapter: permite usar un termometro Fahrenheit con una aplicación que espera un termometro Celsius.
 */
public final class AppAdapter {

public static void main(String[] args) {

    // CASO 1: Cargador antiguo con registro
    System.out.println("CASO 1");

    Cargador c1 = new DecoradorRegistro(
        new AdaptadorCargador(new CargadorAntiguo())
    );

    c1.cargarCelular();

    // CASO 2: Cargador inalámbrico con seguridad permitida
    System.out.println("\nCASO 2");

    Cargador c2 = new DecoradorSeguridad(
        new AdaptadorCargadorIna(new CargadorInalambrico()),
        true
    );

    c2.cargarCelular();

    // CASO 3: Cargador antiguo con seguridad bloqueada
    System.out.println("\nCASO 3");

    Cargador c3 = new DecoradorSeguridad(
        new AdaptadorCargador(new CargadorAntiguo()),
        false
    );

    c3.cargarCelular();

    // CASO 4: Cargador inalámbrico con dos decoradores
    System.out.println("\nCASO 4");

    Cargador c4 = new DecoradorSeguridad(
        new DecoradorRegistro(
            new AdaptadorCargadorIna(new CargadorInalambrico())
        ),
        true
    );

    c4.cargarCelular();
}

}
