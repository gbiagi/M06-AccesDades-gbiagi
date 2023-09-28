package Pr12LecturaEscritura;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PR122cat {
    public static void main(String pathFile) {
        File file122 = new File(pathFile);
        if (file122.isFile()) {
            try {
                Scanner readFile = new Scanner(file122);
                while (readFile.hasNextLine()) {
                    System.out.println(readFile.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La ruta no es d'un fitxer");
        }
    }
}