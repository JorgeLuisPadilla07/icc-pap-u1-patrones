package icc.pap.u1.patrones;

import icc.pap.u1.patrones.creacionales.SingletonDemo;

public class App {

    public static void main(String[] args) {
        runSingleton();//Corre el programa
        runPrototype();
        runBuilder();
    }

    public static void runSingleton() {
        SingletonDemo c1 = SingletonDemo.getInstancia();
        SingletonDemo c2 = SingletonDemo.getInstancia();

        c1.conectar();
        c2.conectar();

        System.out.println("¿Son la misma instancia? " + (c1 == c2));
    }

    private static void runPrototype() {
        System.out.println();
        System.out.println("Funcionamiento de Patron Prototype");
        System.out.println();
        // Instanciamos el objeto original
        PrototypeDemo alumno1 = new PrototypeDemo("Teo", 23);
        // Clonamos el objeto
        PrototypeDemo alumno2 = alumno1.clone();
        alumno2.setNombre("Andrea");
        alumno2.setEdad(19);
        // Imprimimos el original
        System.out.println("Nombre: " + alumno1.getNombre() + " | "
                + "Edad: " + alumno1.getEdad());
        // Imprimimos la copia
        System.out.println("Nombre: " + alumno2.getNombre() + " | "
                + "Edad: " + alumno2.getEdad());

    }
    
    private static void runBuilder() {
        Pizza pizza = new PizzaBuilder().addIng("Jamon").setSize("large").addIng("Queso").addIng("Salami").build();
        Pizza pizza2 = new PizzaBuilder().build();
        System.out.println(pizza.descripcion());
        System.out.println(pizza2.descripcion());
    }
}