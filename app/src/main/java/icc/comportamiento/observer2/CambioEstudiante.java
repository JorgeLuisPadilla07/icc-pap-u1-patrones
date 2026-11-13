package icc.comportamiento.observer2;

public record CambioEstudiante(
        Estudiante estudiante,
        String atributo,
        Object anterior,
        Object nuevo
) {
}
