
package icc.comportamiento.observer;

import java.util.function.Consumer;

public class Observadores {

    public static Consumer<CambioEstudiante> auditoria = cambio -> {

        System.out.println("[AUDITORIA] "
                + cambio.estudiante().getCodigo()
                + " - "
                + cambio.estudiante().getNombre());

        System.out.println("Atributo: " + cambio.atributo());
        System.out.println("Anterior: " + cambio.anterior());
        System.out.println("Nuevo: " + cambio.nuevo());
    };

    public static Consumer<CambioEstudiante> academico = cambio -> {

        if (!cambio.atributo().equals("PROMEDIO")) return;

        double anterior = (double) cambio.anterior();
        double nuevo = (double) cambio.nuevo();

        String nombre = cambio.estudiante().getNombre();

        if (anterior >= 7.0 && nuevo < 7.0) {

            System.out.println("[ACADEMICO] ALERTA: "
                    + nombre + " tiene bajo rendimiento. Promedio: "
                    + nuevo);

        } else if (anterior < 7.0 && nuevo >= 7.0) {

            System.out.println("[ACADEMICO] RECUPERACION: "
                    + nombre + " superó el promedio mínimo. Nuevo promedio: "
                    + nuevo);
        }
    };

    public static Consumer<CambioEstudiante> asistencia = cambio -> {

        if (!cambio.atributo().equals("INASISTENCIAS")) return;

        int anterior = (int) cambio.anterior();
        int nuevo = (int) cambio.nuevo();

        String nivelAnterior = obtenerNivel(anterior);
        String nivelNuevo = obtenerNivel(nuevo);

        if (!nivelAnterior.equals(nivelNuevo)) {

            System.out.println("[ASISTENCIA] "
                    + cambio.estudiante().getNombre());

            System.out.println("Cambio de nivel: "
                    + nivelAnterior + " -> " + nivelNuevo);

            System.out.println("Alerta de asistencia: " + nivelNuevo);
        }
    };

    public static Consumer<CambioEstudiante> matricula = cambio -> {

        if (!cambio.atributo().equals("MATRICULA")) return;

        EstadoMatricula nuevo = (EstadoMatricula) cambio.nuevo();

        switch (nuevo) {

            case SUSPENDIDO ->
                    System.out.println("[MATRICULA] "
                            + cambio.estudiante().getNombre()
                            + " ha sido SUSPENDIDO.");

            case RETIRADO ->
                    System.out.println("[MATRICULA] "
                            + cambio.estudiante().getNombre()
                            + " ha sido RETIRADO.");

            case ACTIVO ->
                    System.out.println("[MATRICULA] "
                            + cambio.estudiante().getNombre()
                            + " ha sido REACTIVADO.");
        }
    };

    public static Consumer<CambioEstudiante> integral = cambio -> {

        Estudiante e = cambio.estudiante();

        boolean riesgoAnterior = false;

        // Evaluar las condiciones ANTES del cambio
        switch (cambio.atributo()) {

            case "PROMEDIO" ->

                    riesgoAnterior =
                            (double) cambio.anterior() < 7.0
                            && e.getInasistencias() >= 6
                            && e.getEstadoMatricula() == EstadoMatricula.ACTIVO;

            case "INASISTENCIAS" ->

                    riesgoAnterior =
                            e.getPromedio() < 7.0
                            && (int) cambio.anterior() >= 6
                            && e.getEstadoMatricula() == EstadoMatricula.ACTIVO;

            case "MATRICULA" ->

                    riesgoAnterior =
                            e.getPromedio() < 7.0
                            && e.getInasistencias() >= 6
                            && cambio.anterior() == EstadoMatricula.ACTIVO;
        }

        // Evaluar las condiciones DESPUES del cambio
        boolean riesgoNuevo =
                e.getPromedio() < 7.0
                && e.getInasistencias() >= 6
                && e.getEstadoMatricula() == EstadoMatricula.ACTIVO;

        // Alertar solamente cuando aparece una nueva situación de riesgo
        if (!riesgoAnterior && riesgoNuevo) {

            System.out.println("[RIESGO INTEGRAL] ALERTA: "
                    + e.getNombre()
                    + " presenta riesgo académico.");

            System.out.println("Promedio: " + e.getPromedio());
            System.out.println("Inasistencias: " + e.getInasistencias());
            System.out.println("Matrícula: " + e.getEstadoMatricula());
        }
    };

    public static Consumer<CambioEstudiante> representante = cambio -> {

        String nombre = cambio.estudiante().getNombre();

        switch (cambio.atributo()) {

            case "PROMEDIO" -> {

                double anterior = (double) cambio.anterior();
                double nuevo = (double) cambio.nuevo();

                if (anterior >= 6.0 && nuevo < 6.0) {

                    System.out.println("[REPRESENTANTE] NOTIFICAR: "
                            + nombre
                            + " tiene promedio inferior a 6.0.");
                }
            }

            case "INASISTENCIAS" -> {

                int anterior = (int) cambio.anterior();
                int nuevo = (int) cambio.nuevo();

                if (anterior < 8 && nuevo >= 8) {

                    System.out.println("[REPRESENTANTE] NOTIFICAR: "
                            + nombre
                            + " registra 8 o más inasistencias.");
                }
            }

            case "MATRICULA" -> {

                if (cambio.nuevo() == EstadoMatricula.SUSPENDIDO) {

                    System.out.println("[REPRESENTANTE] NOTIFICAR: "
                            + nombre
                            + " tiene su matrícula suspendida.");
                }
            }
        }
    };

    public static String obtenerNivel(int inasistencias) {

        if (inasistencias <= 2) {
            return "NORMAL";
        }

        if (inasistencias <= 5) {
            return "ADVERTENCIA";
        }

        return "CRITICO";
    }
}
