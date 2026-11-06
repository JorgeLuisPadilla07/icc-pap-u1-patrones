package icc.Estructurales.simple.bridge;

public class AppBridge {
    public static void main(String[] args) {
        Notificacion not1 = new NotificacionAcademica(new CanalCorreo());
        Notificacion not2 = new NotificacionAcademica(new CanalPush());

        Notificacion notSegCor = new NotificacionSeguridad(new CanalCorreo());
        Notificacion notSegPush = new NotificacionSeguridad(new CanalPush());

        String mensajeAca = "Solicitud #44 aprobada";
        String mensajeSeg = "Alerta de correos Maliciosos";

        not1.notificar(mensajeAca);
        not2.notificar(mensajeAca);

        notSegCor.notificar(mensajeSeg);
        notSegPush.notificar(mensajeSeg);
    }
}
