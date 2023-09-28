package Pr12LecturaEscritura;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PR125cp {
    public static void main(String pathSource, String pathTarget) {
        Scanner readFile;
        try {
            String data = "";
            File fileToCopy = new File(pathSource);
            FileWriter copiedFile = new FileWriter(pathTarget);
            readFile = new Scanner(fileToCopy);
            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                data = data + line + "\n";
            }
            copiedFile.write(data);
            copiedFile.close();
            readFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
