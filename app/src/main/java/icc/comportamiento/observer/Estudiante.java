package icc.comportamiento.observer;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Estudiante {

    private String codigo;
    private String nombre;
    private double promedio;
    private int inasistencias;
    private EstadoMatricula estadoMatricula;

    // Lista de observadores
    private final List<Consumer<CambioEstudiante>> observadores;

    // Constructor
    public Estudiante(String codigo, String nombre,
                      double promedio, int inasistencias,
                      EstadoMatricula estadoMatricula) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.promedio = promedio;
        this.inasistencias = inasistencias;
        this.estadoMatricula = estadoMatricula;

        this.observadores = new ArrayList<>();
    }

    // Suscribir observadores
    public void suscribir(Consumer<CambioEstudiante> observador) {
        observadores.add(observador);
    }

    // Notificar cambios
    private void notificar(CambioEstudiante cambio) {

        for (Consumer<CambioEstudiante> observador : observadores) {
            observador.accept(cambio);
        }
    }

    // =====================================
    // GETTERS
    // =====================================

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public int getInasistencias() {
        return inasistencias;
    }

    public EstadoMatricula getEstadoMatricula() {
        return estadoMatricula;
    }

    // =====================================
    // SETTERS CON NOTIFICACION
    // =====================================

    public void setCodigo(String codigo) {

        if (this.codigo.equals(codigo)) return;

        String anterior = this.codigo;
        this.codigo = codigo;

        notificar(new CambioEstudiante(
                this, "CODIGO", anterior, codigo));
    }

    public void setNombre(String nombre) {

        if (this.nombre.equals(nombre)) return;

        String anterior = this.nombre;
        this.nombre = nombre;

        notificar(new CambioEstudiante(
                this, "NOMBRE", anterior, nombre));
    }

    public void setPromedio(double promedio) {

        if (this.promedio == promedio) return;

        if (promedio < 0 || promedio > 10) {
            throw new IllegalArgumentException(
                    "El promedio debe estar entre 0 y 10");
        }

        double anterior = this.promedio;
        this.promedio = promedio;

        notificar(new CambioEstudiante(
                this, "PROMEDIO", anterior, promedio));
    }

    public void setInasistencias(int inasistencias) {

        if (inasistencias < 0) {
            throw new IllegalArgumentException(
                    "Las inasistencias no pueden ser negativas");
        }

        if (this.inasistencias == inasistencias) return;

        int anterior = this.inasistencias;
        this.inasistencias = inasistencias;

        notificar(new CambioEstudiante(
                this, "INASISTENCIAS", anterior, inasistencias));
    }

    public void setEstadoMatricula(EstadoMatricula estadoMatricula) {

        if (this.estadoMatricula == estadoMatricula) return;

        EstadoMatricula anterior = this.estadoMatricula;
        this.estadoMatricula = estadoMatricula;

        notificar(new CambioEstudiante(
                this, "MATRICULA", anterior, estadoMatricula));
    }
}
