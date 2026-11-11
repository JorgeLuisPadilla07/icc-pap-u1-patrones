package icc.comportamiento.observer;

public record CambioEstudiante(
        Estudiante estudiante,
        String atributo,
        Object anterior,
        Object nuevo
) {
}
