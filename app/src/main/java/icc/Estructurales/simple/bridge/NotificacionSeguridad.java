package icc.Estructurales.simple.bridge;

public class NotificacionSeguridad extends Notificacion {

    public NotificacionSeguridad(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void notificar(String mensaje) {
        canal.enviar("Not de Seguridad: " + mensaje);
    }

}
