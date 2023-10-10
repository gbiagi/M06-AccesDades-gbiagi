package Pr13Serialize;

import java.io.Serializable;
import java.util.HashMap;

public class PR131hashmap implements Serializable {
    HashMap<String, Integer> listaPersonas = new HashMap<>();

    public PR131hashmap() {
        this.listaPersonas.put("David", 23);
        this.listaPersonas.put("Gean", 28);
        this.listaPersonas.put("Alejandro", 30);
        this.listaPersonas.put("Pablo", 49);
        this.listaPersonas.put("Manuel", 75);
    }

    @Override
    public String toString() {
        String data = "";
        for (String key : listaPersonas.keySet()){
            data += "Nom : " + key + " Edat: " + listaPersonas.get(key) + "\n";
        }
        return data;
    }
}
