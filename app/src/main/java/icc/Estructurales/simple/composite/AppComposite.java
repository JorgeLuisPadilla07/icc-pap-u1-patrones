package icc.Estructurales.simple.composite;

public class AppComposite {
    public static void main(String[] args) {
        GrupoMenu combo = new GrupoMenu();
        
        GrupoMenu hamburguesa = new GrupoMenu();
        hamburguesa.addItem(new ProductoMenu("Queso", 0.5));
        hamburguesa.addItem(new ProductoMenu("Carne", 1));
        hamburguesa.addItem(new ProductoMenu("Pan", 0.5));
        hamburguesa.addItem(new ProductoMenu("Lechuga", 0.25));

        ProductoMenu bebida = new ProductoMenu("Coca Cola", 1.35);

        combo.addItem(hamburguesa); //Agrege un GP (hamburguesa)
        combo.addItem(bebida); // Agrege un PM (bebida)

        System.out.println("Total del combo: $" + combo.precio());
    }
}
