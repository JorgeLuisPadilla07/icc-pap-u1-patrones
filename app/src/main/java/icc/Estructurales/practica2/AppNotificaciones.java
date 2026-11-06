package icc.Estructurales.practica2;

public class AppNotificaciones {
    public static void main(String[] args) {

        System.out.println("Caso 1: Académica por correo");
        Notificacion n1 = new NotificacionAcademica(new CanalCorreo());
        n1.notificar("estudiante@universidad.edu", "Tus calificaciones están disponibles");



        System.out.println("\nCaso 2: Administrativa por SMS");
        Notificacion n2 = new NotificacionAdministrativa(new CanalSMS());
        n2.notificar("0991234567", "Tienes un trámite pendiente");



        System.out.println("\n Caso 3:Notificacion de seguridad autorizada");
        CanalEnvio proxyAutorizado = new ProxyCanalEnvio(new CanalPush(), true);
        Notificacion n3 = new NotificacionSeguridad(proxyAutorizado);
        n3.notificar("usuario123", "Se detecto un nuevo inicio de sesión");



        System.out.println("\n--- Caso 4: Académica por SMS sin autorización ---");
        Notificacion n4 = new NotificacionAcademica(new ProxyCanalEnvio(new CanalSMS(), false));
        n4.notificar("0987654321", "Nueva calificación publicada");



        System.out.println("\n--- Caso 5: Mismo CanalCorreo, dos notificaciones ---");
        CanalEnvio correo = new CanalCorreo();
        Notificacion acad = new NotificacionAcademica(correo);
        Notificacion admin = new NotificacionAdministrativa(correo);
        acad.notificar("estudiante@universidad.edu", "Revisa tu horario de exámenes");
        admin.notificar("estudiante@universidad.edu", "Matrícula por renovar");



        System.out.println("\n--- Caso 6: Bridge + Proxy, uno autorizado y otro no ---");
        Notificacion segCorreo = new NotificacionSeguridad(new ProxyCanalEnvio(new CanalCorreo(), true));
        Notificacion segSMS = new NotificacionSeguridad(new ProxyCanalEnvio(new CanalSMS(), false));
        segCorreo.notificar("docente@universidad.edu", "Cambio de contraseña requerido");
        segSMS.notificar("0991112233", "Cambio de contraseña requerido");
    }
}