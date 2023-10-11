package Pr13Serialize;
import java.util.List;
import java.util.Scanner;


public class PR133mainTreballadors {
    public static void main(String[] args) {

        String path = "./src/Pr13Serialize/Archivos/PR133treballadors.csv";
        Scanner scnr = new Scanner(System.in);

        List<String> csv = UtilsCSV.read(path);
        UtilsCSV.list(csv);

        System.out.println("\nID del treballador: ");
        String id = scnr.nextLine();
        System.out.println("Columna a modificar: ");
        String columnMod = scnr.nextLine();
        System.out.println("Nou valor: ");
        String newValue = scnr.nextLine();
        scnr.close();

        int lineMod = UtilsCSV.getLineNumber(csv, "Id", id);

        UtilsCSV.update(csv, lineMod, columnMod, newValue);
        UtilsCSV.write(path, csv);
        System.out.println("Dades guardades.");
    }

}
