package icc.Estructurales.practica2;

public class NotificacionSeguridad extends Notificacion {
    public NotificacionSeguridad(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void notificar(String destinatario, String mensaje) {
        canal.enviar(destinatario, "Seguridad: " + mensaje);
    }
}