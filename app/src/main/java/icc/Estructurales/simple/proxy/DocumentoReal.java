package icc.Estructurales.simple.proxy;

public class DocumentoReal implements Documento {
    private final String path;

    public DocumentoReal(String path) {
        this.path = path;
        // Cargar el documento real desde el archivo
        System.out.println("Cargando documento desde: " + path);
    }

    @Override
    public void mostrar() {
        // Mostrar el documento real
        System.out.println("Mostrando documento desde: " + path);
    }
    
}
