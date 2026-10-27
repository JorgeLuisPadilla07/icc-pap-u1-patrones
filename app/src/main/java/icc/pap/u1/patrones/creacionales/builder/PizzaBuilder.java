package icc.pap.u1.patrones.creacionales.builder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ObjBuilder
 * PizzaBuilder acumular las opciones de una pizza
 * y crear el producto(Objeto(Pizza)) cuando se le pida
 * al metodo construir(build)
 */

public final class PizzaBuilder {
    private String size = "mediana";
    private Set<String> ingredientes;

    // VACIO --> Default constructor
    public PizzaBuilder() {
        this.size = "mediana";
        this.ingredientes = new HashSet<>();
        this.ingredientes.add("Queso");
    }

    public PizzaBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder addIng(String ing) {
        this.ingredientes.add(ing);
        return this;
    }

    // Metodo build
    // devuelve el producto
    public Pizza build() {
        return new Pizza(size, ingredientes);
    }
}
