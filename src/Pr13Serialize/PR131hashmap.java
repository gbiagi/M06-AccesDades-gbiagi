package Pr13Serialize;

import java.io.Serializable;
import java.util.HashMap;

public class PR131hashmap implements Serializable {
    public static void main(String[] args) {
        HashMap<String, Integer> listaPersonas = new HashMap<>();
        listaPersonas.put("David", 23);
        listaPersonas.put("Gean", 28);
        listaPersonas.put("Alejandro", 30);
        listaPersonas.put("Pablo", 49);
        listaPersonas.put("Manuel", 75);
    }
    void PR131hashmap() {}
}
