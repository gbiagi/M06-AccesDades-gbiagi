package Pr12LecturaEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PR124linies {
    public static void main(String[] args) {
        File fileNumeros = new File("./src/Pr12LecturaEscritura/Archivos/numeros.txt");
        try {
            if (fileNumeros.createNewFile()) {
                System.out.println("File created: " + fileNumeros.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) { e.printStackTrace(); }
        try {
            FileWriter numerosWrite = new FileWriter("./src/Pr12LecturaEscritura/Archivos/numeros.txt");
            for (int i = 0; i < 10; i++) {
                if (i == 9) {
                    numerosWrite.write(String.valueOf((int)Math.floor(Math.random()*100)));
                } else {
                    numerosWrite.write((int)Math.floor(Math.random()*100) + "\n");
                }
            }
            numerosWrite.close();
        }catch (IOException e) { e.printStackTrace(); }
    }
}
