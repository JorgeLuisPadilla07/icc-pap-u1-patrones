package icc.comportamiento.observer;

public class AppObserver {
    public static void main(String[] args) {
        Producto p = new Producto("001", 20.50, "Pizza");

        //p.suscribir(producto -> System.out.println("Correo: $" + producto.getPrecio()));
        //p.suscribir(producto -> System.out.println("Registro: $" + producto.getPrecio()));

        //String cod0Id = p.getCodigo();
        //p.suscribir(producto -> {
        //    if (!cod0Id.equals(producto.getCodigo())) {
        //        System.out.println("El codigo viejo es: " + cod0Id + " y el nuevo es: " + producto.getCodigo());
        //    }
        //});

        //System.out.println("Cambio de precio");
        //p.setPrecio(5.50);
        
        //System.out.println("Cambio de nombre");
        //p.setNombre("Pizza");

        p.suscribir(cp -> {
            System.out.println("Se modifico el " + cp.atributo());
            System.out.println("Old: " + cp.anterior() + "| New = " + cp.nuevo());
        });
    }   
}