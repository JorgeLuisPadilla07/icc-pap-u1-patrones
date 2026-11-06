package icc.Estructurales.simple.bridge;

public class CanalPush implements CanalEnvio {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Push: " + mensaje);
    }
}
