package icc.pap.u1.patrones;

import icc.pap.u1.patrones.creacionales.SingletonDemo;
import icc.pap.u1.patrones.creacionales.builder.Pizza;
import icc.pap.u1.patrones.creacionales.builder.PizzaBuilder;

public class App {

    public static void main(String[] args) {
        runSingleton();//Corre el programa
        runBuilder();
    }

    public static void runSingleton() {
        SingletonDemo c1 = SingletonDemo.getInstancia();
        SingletonDemo c2 = SingletonDemo.getInstancia();

        c1.conectar();
        c2.conectar();

        System.out.println("¿Son la misma instancia? " + (c1 == c2));
    }

    
    private static void runBuilder() {
        Pizza pizza = new PizzaBuilder().addIng("Jamon").setSize("large").addIng("Queso").addIng("Salami").build();
        Pizza pizza2 = new PizzaBuilder().build();
        System.out.println(pizza.descripcion());
        System.out.println(pizza2.descripcion());
    }
}