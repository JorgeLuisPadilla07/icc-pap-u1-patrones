package icc.Estructurales.simple.composite;

public class ProductoMenu implements ElementoMenu {
    private final String nombre;
    private final double precio;
    
    public ProductoMenu(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    
    @Override
    public double precio() {
        return precio;
    }

    @Override 
    public String toString(){
        return nombre;
    }
    
}
