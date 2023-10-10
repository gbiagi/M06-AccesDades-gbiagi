package Pr13Serialize;

import java.io.*;

public class Pr132main {
    public static void main(String[] args) {
        // Crear objetos con los datos
        PR132persona persona1 = new PR132persona("Maria", "Lopez", 36);
        PR132persona persona2 = new PR132persona("Gustavo", "Ponts", 63);
        PR132persona persona3 = new PR132persona("Irene", "Sales", 54);

        // Guardar objetos
        try {
            FileOutputStream fileOS = new FileOutputStream("./src/Pr13Serialize/Archivos/PR132people.ser");
            ObjectOutputStream objOS = new ObjectOutputStream(fileOS);

            objOS.writeObject(persona1);
            objOS.writeObject(persona2);
            objOS.writeObject(persona3);

            objOS.close();
            fileOS.close();

            System.out.println("Objectes guardats");
        } catch (IOException e) {e.printStackTrace();}

        // Leer objetos
        try {
            FileInputStream fileIN = new FileInputStream("./src/Pr13Serialize/Archivos/PR132people.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIN);

            PR132persona persona1copy = (PR132persona) objIn.readObject();
            PR132persona persona2copy = (PR132persona) objIn.readObject();
            PR132persona persona3copy = (PR132persona) objIn.readObject();

            System.out.println(persona1copy);
            System.out.println(persona2copy);
            System.out.println(persona3copy);

        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
    }
}
