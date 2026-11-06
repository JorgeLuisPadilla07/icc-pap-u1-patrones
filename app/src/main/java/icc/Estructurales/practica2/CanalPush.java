package icc.Estructurales.practica2;

public class CanalPush implements CanalEnvio {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Push para " + destinatario + ": " + mensaje);
    }
}