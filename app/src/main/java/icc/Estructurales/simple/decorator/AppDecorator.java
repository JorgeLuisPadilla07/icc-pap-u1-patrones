package icc.Estructurales.simple.decorator;

public class AppDecorator {
    public static void main(String[] args) {
        //Bebida -> CafeSimple
        Bebida bebida = new CafeSimple();
        //System.out.println(bebida.descripcion() + " $" + bebida.precio());

        //Bebida -> cafe simple + leche
        Bebida bebidal = new Leche(new CafeSimple());
        Bebida bebidal2 = new Leche(new CafeSimple());
        //System.out.println(bebidal2.descripcion() + " $" + bebidal2.precio());

        //Con chocolate

        Bebida cafeS = new CafeSimple();
        Bebida cafeSL =  new Leche(cafeS);
        Bebida cafeSC = new Chocolate(cafeS);

        Bebida cafeSCL = new Chocolate(cafeSL);
        Bebida cafeSLC = new Leche(cafeSC);
        Bebida cafeSCC = new Chocolate(cafeSC);
        Bebida cafeSCCL = new Leche(cafeSCC);

        System.out.println(cafeSC.descripcion()+ " $"+cafeSC.precio());
        System.out.println(cafeSCL.descripcion()+ " $"+ cafeSCL.precio());
        System.out.println(cafeSLC.descripcion()+ " $"+ cafeSLC.precio());
        System.out.println(cafeSCCL.descripcion()+ " $"+ cafeSCCL.precio());


        
    }
}
