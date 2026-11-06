package icc.Estructurales.practica2;

public class ProxyCanalEnvio implements CanalEnvio {
    private CanalEnvio canalReal;
    private boolean autorizado;

    public ProxyCanalEnvio(CanalEnvio canalReal, boolean autorizado) {
        this.canalReal = canalReal;
        this.autorizado = autorizado;
    }

    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Verificando autorización para " + destinatario + "...");
        if (autorizado) {
            canalReal.enviar(destinatario, mensaje);
        } else {
            System.out.println("Envío bloqueado: usuario no autorizado.");
        }
    }
}