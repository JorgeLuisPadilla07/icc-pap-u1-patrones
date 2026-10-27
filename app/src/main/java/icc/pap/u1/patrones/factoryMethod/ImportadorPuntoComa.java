package icc.pap.u1.patrones.factoryMethod;

public class ImportadorPuntoComa extends Importador {
    @Override
    protected LecturaLinea crearLector() {
        return new LecturaPuntoComa();
    }
}