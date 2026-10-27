package icc.pap.u1.patrones.factoryMethod;

public class ImportadorTabulacion extends Importador {
    @Override
    protected LecturaLinea crearLector() {
        return new LecturaTabulacion();
    }
}
