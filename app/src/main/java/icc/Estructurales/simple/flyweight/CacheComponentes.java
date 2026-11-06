package icc.Estructurales.simple.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CacheComponentes {

    private final Map<String, ComponenteVisual> componentes;

    public CacheComponentes() {
        componentes = new HashMap<>();
    }

    public ComponenteVisual get(String tipo, String color, String border) {
        String clave = tipo + "|" + color + "|" + border;
        return componentes.computeIfAbsent(clave,k -> new ComponenteVisual(tipo, color, border));
    }


}
