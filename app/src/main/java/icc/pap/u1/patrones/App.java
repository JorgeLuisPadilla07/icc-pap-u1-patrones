package icc.pap.u1.patrones;

import icc.Practica.gestionpedidos.Configuracion;
import icc.Practica.gestionpedidos.FabricaDigital;
import icc.Practica.gestionpedidos.FabricaPedido;
import icc.Practica.gestionpedidos.FabricaTienda;
import icc.pap.u1.patrones.creacionales.SingletonDemo;
import icc.pap.u1.patrones.creacionales.builder.Pizza;
import icc.pap.u1.patrones.creacionales.builder.PizzaBuilder;

public class App {

    public static void main(String[] args) {
        //runSingleton();//Corre el programa
        //runFactoryMethod();
        //runBuilder();
        runPedidos();//Trabajo
    }

    private static void runPedidos(){
        // Singleton: obtenemos la configuración
        Configuracion config = Configuracion.getInstancia();
        System.out.println("Configuración del sistema");
        System.out.println("Impuesto: " + config.getImpuesto() + "%");

        // Factory Method: una fábrica por cada tipo de pedido
        FabricaPedido fabricaTienda = new FabricaTienda();
        FabricaPedido fabricaDigital = new FabricaDigital();

        System.out.println();
        System.out.println("--- Pedido presencial ---");
        fabricaTienda.registrarYProcesar("P001", "Ana Torres", 100.00);

        System.out.println();
        System.out.println("--- Pedido en línea ---");
        fabricaDigital.registrarYProcesar("P002", "Juan Pérez", 200.00);

        // Comprobamos que es la misma instancia
        Configuracion otra = Configuracion.getInstancia();
        System.out.println();
        System.out.println("Configuración compartida: " + (config == otra));
    }

    public static void runSingleton() {
        SingletonDemo c1 = SingletonDemo.getInstancia();
        SingletonDemo c2 = SingletonDemo.getInstancia();

        c1.conectar();
        c2.conectar();

        System.out.println("¿Son la misma instancia? " + (c1 == c2));
    }

    // private static void runFactoryMethod() {
    //     Importador impPC = new ImportadorPuntoComa();
    //     Importador impT = new ImportadorTabulacion();
    //     // implemeto el crearLector()
    //     // para devolver LecturaPuntoComa
    //     System.out.println(impPC.importacion(List.of("S01;22.5;C", "S02;18;C")));
    //     System.out.println(impT.importacion(List.of("S01\t22\tC", "S02\t18\tC")));
    // }

    
    private static void runBuilder() {
        Pizza pizza = new PizzaBuilder().addIng("Jamon").setSize("large").addIng("Queso").addIng("Salami").build();
        Pizza pizza2 = new PizzaBuilder().build();
        System.out.println(pizza.descripcion());
        System.out.println(pizza2.descripcion());
    }
}