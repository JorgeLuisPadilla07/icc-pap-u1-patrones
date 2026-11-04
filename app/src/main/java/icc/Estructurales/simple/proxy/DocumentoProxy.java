package icc.Estructurales.simple.proxy;

/**
 * Proxy que pospone la creacion de un documento real
 * hasta que se lo necesite.
 * DocumentoProxy
 */
public class DocumentoProxy implements Documento {
    private final String path;
    private DocumentoReal documento;

    public DocumentoProxy(String path) {
        this.path = path;
    }

    @Override
    public void mostrar() {
        if (documento == null) {
            documento = new DocumentoReal(path);
            // Cargar el documento real desde el archivo
            documento.mostrar();
    }
    } 
}
