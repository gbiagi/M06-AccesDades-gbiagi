package Pr12LecturaEscritura;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PR125cp {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Scanner readFile;
        String pathSource;
        String pathTarget;

        try {
            System.out.println("Ruta archivo: ");
            pathSource = scnr.nextLine();
            System.out.println("Ruta de destinacio: ");
            pathTarget = scnr.nextLine();
            scnr.close();
            //File copiedFile = new File(pathTarget);
            FileWriter copiedFile = new FileWriter(pathTarget);
            readFile = new Scanner(pathSource);
            while (readFile.hasNextInt()) {
                String line = readFile.nextLine();
                copiedFile.write(line);
            }
            copiedFile.close();
            readFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
