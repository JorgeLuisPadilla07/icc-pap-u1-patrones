package icc.Estructurales.practica2;

public class CanalCorreo implements CanalEnvio {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Correo a " + destinatario + ": " + mensaje);
    }
}