package Pr12LecturaEscritura;

import java.io.FileWriter;
import java.io.IOException;

public class PR123sobreescriu {
    public static void main(String[] args) {
        try {
            FileWriter matrixWriter = new FileWriter("./src/Pr12LecturaEscritura/Archivos/frasesMatrix.txt");
            matrixWriter.write("Yo sólo puedo mostrarte la puerta\n");
            matrixWriter.write("Tú eres quien la tiene que atravesar\n");
            matrixWriter.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}
