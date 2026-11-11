package icc.comportamiento.observer;

import java.util.List;
import java.util.function.Consumer;
import java.util.ArrayList;

public class Producto {

    private String codigo;
    private Double precio;
    private String nombre;

    public final List<Consumer<CambioProducto>> observadores;

    public Producto(String codigo, Double precio, String nombre) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.observadores = new ArrayList<>();
    }

    public Producto() {
        this.observadores = new ArrayList<>();
    }

    public void suscribir(Consumer<CambioProducto> observador) {
        this.observadores.add(observador);
    }

    private void notifyAll(CambioProducto p) {
        for (Consumer<CambioProducto> observador : observadores) {
            observador.accept(p);
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        String cod0ld = this.codigo;
        CambioProducto cP = new CambioProducto(this, "codigo", cod0ld, codigo);

        notifyAll(cP);
    }

    public Double getPrecio() {
        return precio;
    }

    //public void setPrecio(Double precio) {
    //    this.precio = precio;
    //    notifyAll();
    //}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        notifyAll();
    }

    public List<Consumer<CambioProducto>> getObservadores() {
        return observadores;
    }
}