package icc.Estructurales.simple.bridge;

public class CanalCorreo implements CanalEnvio {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Correo: " + mensaje);
    }
}
