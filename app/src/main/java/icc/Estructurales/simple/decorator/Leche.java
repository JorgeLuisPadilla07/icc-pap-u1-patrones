package icc.Estructurales.simple.decorator;
/**
 * 
 * Leche es DECORADOR que envuelve a una BEBIDA
 * BEBIDA -> general puede ser cualquiera como un cafe
 * un expreso, chocolate.
 */
public final class Leche implements Bebida{
    protected final Bebida bebida;

    public Leche(Bebida bebida){
        this.bebida = bebida;
    }

    @Override 
    public String descripcion(){
        return bebida.descripcion() + " con leche";
    }
    @Override 
    public double precio(){
        return bebida.precio() + 0.5;
    }

}
