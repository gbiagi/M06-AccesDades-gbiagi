package Pr13Serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class PR131mainEscriu {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOS = new FileOutputStream("./src/Pr13Serialize/Archivos/PR131HashMapData.ser");
            ObjectOutputStream objOS = new ObjectOutputStream(fileOS);

            PR131hasmap obj1 = new PR131hasmap();
            objOS.writeObject(obj1);

            fileOS.close();
            objOS.close();

            System.out.println("Objecte guardat");

        } catch (IOException e) {e.printStackTrace();}

    }
}
