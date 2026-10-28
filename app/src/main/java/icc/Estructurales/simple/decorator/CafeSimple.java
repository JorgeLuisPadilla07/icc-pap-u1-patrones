package icc.Estructurales.simple.decorator;

public class CafeSimple implements Bebida{
    @Override 
    public String descripcion(){
        return "Un cafecito simple";
    }

    @Override 
    public double precio(){
        return 2.00;
    }
}
