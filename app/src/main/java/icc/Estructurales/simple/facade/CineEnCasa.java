package icc.Estructurales.simple.facade;
/**
 * FAcade es la que coordina los componentes necesarios para una acción determinada
 * ver una película en este caso
 * CineEnCasa
 */
public class CineEnCasa {
    private final Proyector proyector;
    private final Reproductor reproductor;

    public CineEnCasa() {
        this.proyector = new Proyector();
        this.reproductor = new Reproductor();
    }

    public void iniciarPelicula(String pelicula) {
        proyector.encender();
        reproductor.reproducir(pelicula);
    }
}
