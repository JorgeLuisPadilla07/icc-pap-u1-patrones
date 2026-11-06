package icc.Estructurales.practica2;

public class CanalSMS implements CanalEnvio {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("SMS a " + destinatario + ": " + mensaje);
    }
}