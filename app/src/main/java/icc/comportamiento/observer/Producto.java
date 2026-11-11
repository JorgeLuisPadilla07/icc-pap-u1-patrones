package icc.comportamiento.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer; //clase que JAVA ya tiene GUARDADA

public class Producto {
    
    public final List<Consumer<CambioProducto>> observadores;
    //le cambio a Consumer de tipo 
    
    private String codigo;
    private double precio;
    private String nombre;

    public Producto(String codigo, double precio, String nombre){
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.observadores = new ArrayList<>();
    }

    public void suscribir(Consumer<CambioProducto> observador){
        observadores.add(observador);
    }

    private void notifyAll(CambioProducto producto){ //notifica a todos los consumidores
        for(Consumer<CambioProducto> observador : observadores){
            observador.accept(producto);
        }
    }

    public List<Consumer<CambioProducto>> getObservadores() {
        return observadores;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String codigoOld = this.codigo;
        this.codigo = codigo; //respaldo el dato ANTERIOR, antes de que haya un nuevo codigo, hay un viejo codigo

        CambioProducto cProd = new CambioProducto(this, "codigo", codigoOld , codigo); //se guarda el codigo viejo
        notifyAll(cProd);
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        double precioOld = this.precio;
        this.precio = precio;

        CambioProducto cProd = new CambioProducto(this, "precio", precioOld, precio);
        notifyAll(cProd);
        //notifyAll(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String nombreOld = this.nombre;
        this.nombre = nombre;

        CambioProducto cProd = new CambioProducto(this, "nombre", nombreOld, nombre);
        notifyAll(cProd);
        //notifyAll(this);
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo      + ", precio=" + precio     + ", nombre=" + nombre + "]";
    }
}