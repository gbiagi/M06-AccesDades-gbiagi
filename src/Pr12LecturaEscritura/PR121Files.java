package Pr12LecturaEscritura;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PR121Files {
    public static void main(String[] args) {
        String dir = "./src/Pr12LecturaEscritura/";
        File dirName = new File(dir + "myFiles");
        File file1 = new File(dirName + "/" + "file1.txt");
        File file2 = new File(dirName + "/" + "file2.txt");
        Scanner scnr = new Scanner(System.in);

         // Crear carpeta
        if (!dirName.exists()){
            if(!dirName.mkdirs()) {
                System.out.println("Error en la creació de la carpeta '" + dirName + "'");
            } else {
                System.out.println("Carpeta creada");
            }
        }
        System.out.println("Presiona Enter per continuar");
        scnr.nextLine();
        // Crear archivos
        try {
            if (file1.createNewFile()) {
                System.out.println("File created: " + file1.getName());
            } else {
                System.out.println("File already exists.");
            }

            if (file2.createNewFile()) {
                System.out.println("File created: " + file2.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) { e.printStackTrace(); }
        System.out.println("Presiona Enter per continuar");
        scnr.nextLine();

        // Renombra archivo “file2.txt” a “renamedFile.txt”.
        if (file2.renameTo(new File(dirName + "/" + "renamedFile.txt"))){
            System.out.println("File renamed to " + file2.getName() + "\n");
        } else {
            System.out.println("Failed rename\n");
        }
        System.out.println("Presiona Enter per continuar");
        scnr.nextLine();

        // Muestra un listado de los archivos dentro de la carpeta "myfiles" con el mensaje "Els arxius de la carpeta son:"
        try {
            File[] filesList = dirName.listFiles();
            System.out.println("Els archius de la carpeta son:");
            for (File file : filesList){
                System.out.println("Archiu: " + file.getName());
            }
            } catch (Exception e) {e.printStackTrace();}
        System.out.println("Presiona Enter per continuar");
        scnr.nextLine();

        // Elimina “file1.txt”.
            if (file1.delete()) {
                System.out.println(file1.getName() + " deleted");
            } else {
                System.out.println("Failed delete of file.");
            }
        System.out.println("Presiona Enter per continuar");
        scnr.nextLine();

        // Vuelve a mostrar un listado de los archivos de la carpeta "myfiles"
        try {
            File[] filesList = dirName.listFiles();
            System.out.println("\nEls archius de la carpeta son:");
            for (File file : filesList){
                System.out.println("Archiu: " + file.getName());
            }
        } catch (Exception e) {e.printStackTrace();}
    }// Main
}
