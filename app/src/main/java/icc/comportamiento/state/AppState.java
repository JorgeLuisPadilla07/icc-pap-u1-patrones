package icc.comportamiento.state;

public class AppState {
    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo();
        System.out.println(semaforo.color());
        semaforo.avanzar();
        System.out.println(semaforo.color());
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error: ");
        }
        semaforo.avanzar();
        System.out.println(semaforo.color());     
    }
}
