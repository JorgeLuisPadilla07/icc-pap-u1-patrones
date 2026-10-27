package icc.pap.u1.patrones.factoryMethod;

import java.util.ArrayList;
import java.util.List;

public class ImportadorPuntoComa extends Importador {
    // FACTORY METHOD
    protected  abstract LecturaLinea crearLector();
    
    public final List<Lectura> importacion(List<String> lecturas){
        LecturaLinea lector = crearLector();
        //imPC -> ImportadorPuntoComa -> LecturaPuntoComa
        List<Lectura> resultado = new ArrayList<>();
        for(String lectura : lecturas){
            if (lectura.isBlank()) continue;
            try{
                resultado.add(lector.leer(lectura));
            }catch(Exception e){
                throw new IllegalArgumentException("linea mal formada");
            }
        }
        return resultado;
    }
}