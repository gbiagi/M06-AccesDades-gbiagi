package Pr12LecturaEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Pr123 {
    public static void main(String[] args) {
        File fileMatrix = new File("./src/Pr12LecturaEscritura/myFiles/frasesMatrix.txt");
        try {
            if (fileMatrix.createNewFile()) {
                System.out.println("File created: " + fileMatrix.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) { e.printStackTrace(); }
        try {
            FileWriter matrixWriter = new FileWriter("./src/Pr12LecturaEscritura/myFiles/frasesMatrix.txt");
            matrixWriter.write("Yo sólo puedo mostrarte la puerta\n");
            matrixWriter.write("Tú eres quien la tiene que atravesar\n");
            matrixWriter.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}
