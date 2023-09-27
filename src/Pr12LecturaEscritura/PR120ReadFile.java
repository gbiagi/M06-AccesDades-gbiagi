package Pr12LecturaEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PR120ReadFile {
    public static void main(String[] args) {
        int lineNumber = 1;
        File text = new File("./src/Pr12LecturaEscritura/PR120ReadFile.java");
        Scanner scnr;
        try {
            scnr = new Scanner(text);
            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                System.out.println("Linea " + lineNumber + " :" + line);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}