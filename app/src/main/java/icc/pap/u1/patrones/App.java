package icc.pap.u1.patrones;

import icc.pap.u1.patrones.creacionales.SingletonDemo;

public class App {

    public static void main(String[] args) {
        runSingleton();//Corre el programa
    }

    public static void runSingleton() {
        SingletonDemo c1 = SingletonDemo.getInstancia();
        SingletonDemo c2 = SingletonDemo.getInstancia();

        c1.conectar();
        c2.conectar();

        System.out.println("¿Son la misma instancia? " + (c1 == c2));
    }
}