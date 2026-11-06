package icc.Estructurales.simple.bridge;

public abstract class Notificacion {
    protected final CanalEnvio canal;

    public Notificacion(CanalEnvio canal) {
        this.canal = canal;
    }

    public abstract void notificar(String mensaje);
}
