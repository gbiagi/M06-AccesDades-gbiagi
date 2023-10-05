package Pr13Serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PR131mainLlegeix {
    public static void main(String[] args) {
        try {
            FileInputStream fileIN = new FileInputStream("./src/Pr13Serialize/Archivos/PR131HashMapData.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIN);

            System.out.println(objIn);

            fileIN.close();
            objIn.close();

        } catch (IOException e) {e.printStackTrace();}
    }
}