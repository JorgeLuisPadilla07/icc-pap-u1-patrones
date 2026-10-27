package icc.pap.u1.patrones.creacionales.builder;

/**
 * BuilderDemo
 */
public class BuilderDemo {
    private String asignatura;
    private String jornada;

    public BuilderDemo setAsignatura(String asignatura) {
        this.asignatura = asignatura;
        return this;
    }

    public BuilderDemo setJornada(String jornada) {
        this.jornada = jornada;
        return this;
    }

    public void mostrarDatos() {
        System.out.println("Asignatura: " + asignatura);
        System.out.println("Jornada: " + jornada);
    }
}
