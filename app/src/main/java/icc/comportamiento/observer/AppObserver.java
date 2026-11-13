
package icc.comportamiento.observer;

import icc.comportamiento.observer2.EstadoMatricula;
import icc.comportamiento.observer2.Estudiante;
import icc.comportamiento.observer2.Observadores;

public class AppObserver {

    public static void main(String[] args) {

        Producto p = new Producto("001", 20.50, "Pizza");

        // OBSERVADOR 1: CORREO
        p.suscribir(producto ->
                System.out.println("Correo: $" + producto.nuevo())
        );

        // OBSERVADOR 2: REGISTRO
        p.suscribir(producto ->
                System.out.println("Registro: $" + producto.nuevo())
        );

        // OBSERVADOR 3: CAMBIO DE CODIGO
        String cod0Id = p.getCodigo();

        p.suscribir(producto -> {

            if (producto.atributo().equals("CODIGO")
                    && !cod0Id.equals(producto.nuevo())) {

                System.out.println("El codigo viejo es: "
                        + producto.anterior()
                        + " y el nuevo es: "
                        + producto.nuevo());
            }
        });

        // OBSERVADOR 4: INFORMACION DEL CAMBIO
        p.suscribir(cp -> {

            System.out.println("Se modificó el " + cp.atributo());

            System.out.println("Old: " + cp.anterior()
                    + " | New: " + cp.nuevo());
        });

        System.out.println("Cambio de precio");
        p.setPrecio(5.50);

        System.out.println("\nCambio de nombre");
        p.setNombre("Hamburguesa");
        // CREACION DE ESTUDIANTES

        Estudiante ana = new Estudiante(
                "EST001", "Ana Torres", 8.5, 1,
                EstadoMatricula.ACTIVO);

        Estudiante luis = new Estudiante(
                "EST002", "Luis Pérez", 7.2, 4,
                EstadoMatricula.ACTIVO);

        Estudiante maria = new Estudiante(
                "EST003", "María López", 9.1, 0,
                EstadoMatricula.ACTIVO);

        // SUSCRIPCIONES INICIALES

        Estudiante[] estudiantes = {ana, luis, maria};

        for (Estudiante e : estudiantes) {

            e.suscribir(Observadores.auditoria);
            e.suscribir(Observadores.academico);
            e.suscribir(Observadores.asistencia);
            e.suscribir(Observadores.matricula);
            e.suscribir(Observadores.integral);
        }

        // CASO 1: DISMINUCION DEL RENDIMIENTO
 
        mostrarCaso("CASO 1: DISMINUCION DEL RENDIMIENTO");

        ana.setPromedio(6.5);

        // CASO 2: RECUPERACION ACADEMICA

        mostrarCaso("CASO 2: RECUPERACION ACADEMICA");

        ana.setPromedio(7.8);

        // CASO 3: CAMBIO DE NIVEL DE ASISTENCIA=

        mostrarCaso("CASO 3: CAMBIO DE NIVEL DE ASISTENCIA");

        luis.setInasistencias(7);

        // CASO 4: MODIFICACION DE MATRICULA

        mostrarCaso("CASO 4: MODIFICACION DE MATRICULA");

        maria.setEstadoMatricula(EstadoMatricula.SUSPENDIDO);

        maria.setEstadoMatricula(EstadoMatricula.ACTIVO);

        // CASO 5: IDENTIFICACION DE RIESGO

        mostrarCaso("CASO 5: RIESGO INTEGRAL");

        luis.setPromedio(6.4);

        // CASO 6: MODIFICACIONES SIN CAMBIOS

        mostrarCaso("CASO 6: SIN CAMBIOS REALES");

        maria.setPromedio(9.1);

        maria.setInasistencias(0);

        maria.setEstadoMatricula(EstadoMatricula.ACTIVO);

        System.out.println("No se generaron eventos.");

        // CASO 7: MULTIPLES ESTUDIANTES

        mostrarCaso("CASO 7: MULTIPLES ESTUDIANTES");

        ana.setPromedio(8.2);

        maria.setInasistencias(3);

        luis.setInasistencias(8);

        // CASO 8: NUEVO OBSERVADOR

        mostrarCaso("CASO 8: NOTIFICADOR REPRESENTANTE");

        // Suscribir solamente a Ana y Luis
        ana.suscribir(Observadores.representante);

        luis.suscribir(Observadores.representante);

        // Prueba 1: promedio inferior a 6.0
        ana.setPromedio(5.5);

        // Prueba 2: inasistencias iguales o superiores a 8
        ana.setInasistencias(8);

        // Prueba 3: matrícula suspendida
        luis.setEstadoMatricula(EstadoMatricula.SUSPENDIDO);

        // María no está suscrita al nuevo observador
        maria.setPromedio(8.5);

        // FIN DEL PROGRAMA

        mostrarCaso("FIN DE LAS PRUEBAS");

        System.out.println("Sistema de monitoreo académico finalizado.");
    }
    // METODO PARA MOSTRAR LOS CASOS

    public static void mostrarCaso(String titulo) {

        System.out.println("\n====================================");

        System.out.println(titulo);

        System.out.println("====================================");
    }
}
