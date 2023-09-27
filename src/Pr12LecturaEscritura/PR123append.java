package Pr12LecturaEscritura;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PR123append {
    public static void main(String[] args) {
        Scanner scnr = new Scanner("./src/Pr12LecturaEscritura/myFiles/frasesMatrix.txt");
        try {
            while (scnr.hasNextLine()) {
                System.out.println("a");
            }
            FileWriter matrixWriter = new FileWriter("./src/Pr12LecturaEscritura/myFiles/frasesMatrix.txt");
            matrixWriter.write("Yo sólo puedo mostrarte la puerta\n");
            matrixWriter.write("Tú eres quien la tiene que atravesar\n");
            matrixWriter.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}
