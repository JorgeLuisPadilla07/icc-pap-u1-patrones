package icc.Estructurales.simple.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite porque agrupa productos ElementoMenu
 * y calcula un precio en este caso es la sumatoria de todos
 * los ElementoMenu
 * GrupoMenu
 */
public class GrupoMenu implements ElementoMenu {
    
    private List<ElementoMenu> items;

    public GrupoMenu(){
        items = new ArrayList<>();
    }

    @Override 
    public double precio() {
        // la sumatoria de todos
        double suma = 0;
        for(ElementoMenu elementoMenu: items){
            suma += elementoMenu.precio();
        }
        return suma;
    }

    public void addItem(ElementoMenu _item){
        items.add(_item);
    }
    
}
