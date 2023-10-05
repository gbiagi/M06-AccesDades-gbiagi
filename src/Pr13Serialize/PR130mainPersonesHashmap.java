package Pr13Serialize;

import java.io.*;
import java.util.HashMap;
import java.util.SortedMap;

public class PR130mainPersonesHashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> persones = new HashMap<>();
        persones.put("David", 23);
        persones.put("Gean", 28);
        persones.put("Alejandro", 30);
        persones.put("Pablo", 49);
        persones.put("Manuel", 75);

        try {
        FileOutputStream fileOS = new FileOutputStream("./src/Pr13Serialize/Archivos/PR130persones.dat");
        DataOutputStream dataOS = new DataOutputStream(fileOS);
        for(String name : persones.keySet()) {
            dataOS.writeUTF(name);
            dataOS.writeInt(persones.get(name));
        }
        dataOS.flush();
        fileOS.close();
        dataOS.close();
        } catch (IOException e) {e.printStackTrace();}

        FileInputStream fileIN = null;
        DataInputStream dataIN = null;

        try {
            fileIN = new FileInputStream("./src/Pr12LecturaEscritura/Archivos/PR130persones.dat");
            dataIN = new DataInputStream(fileIN);
            int listSize = persones.size();
            String readName;
            int readAge = 0;

            while (dataIN.available() > 0) {
                readName = dataIN.readUTF();
                readAge = dataIN.readInt();
                System.out.println("Nombre: " + readName + ", Edad: " + String.valueOf(readAge));
            }
            fileIN.close();
            dataIN.close();
        }catch (IOException e) {e.printStackTrace();}
    }
}
