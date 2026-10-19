package icc.pap.u1.patrones.creacionales;

public class SingletonDemo {

    private static SingletonDemo instancia;

    private SingletonDemo() {
        System.out.println("Conexión creada");
    }

    public static SingletonDemo getInstancia() {
        if (instancia == null) {
            instancia = new SingletonDemo();
        }
        return instancia;
    }

    public void conectar() {
        System.out.println("Conectado a la base de datos");
    }
}