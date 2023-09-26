package Pr11Hashmaps;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex2 {
    private NavigableMap<String, Float> almacen = new TreeMap<String, Float>();

    public static void main(String[] args) {
        Ex2 ej2 = new Ex2();

        ej2.almacen.put("Zelda", 70.0f);
        ej2.almacen.put("Cavepacker", 10.0f);
        ej2.almacen.put("Starfield", 80.0f);
        boolean close = false;
        while (!close) {
            Scanner sc = new Scanner(System.in);
            String menu = "1)Introduir element\n2)Modificar preu\n3)Eliminar producte\n4)Mostrar productes\n0)Sortir\n";
            System.out.println(menu);

            System.out.println("Opcion: ");
            int opt = sc.nextInt();
            sc.nextLine();
            String new_element;
            float price;
            if (opt == 1) {
                System.out.println("Nom del nou element: ");
                new_element = sc.next();
                sc.nextLine();
                if (ej2.almacen.containsKey(new_element)) {
                    System.out.println("El producte ja existeix.");
                } else {
                    System.out.println("Preu del producte: ");
                    price = sc.nextFloat();
                    sc.nextLine();
                    ej2.insertarElemento(new_element, price);
                }
            } else if (opt == 2) {
                System.out.println("Nom del element a modificar: ");
                new_element = sc.next();
                sc.nextLine();
                if (ej2.almacen.containsKey(new_element)) {
                    System.out.println("Preu del producte: ");
                    price = sc.nextFloat();
                    sc.nextLine();
                    ej2.almacen.remove(new_element);
                    ej2.almacen.put(new_element, price);
                } else {
                    System.out.println("Producte desconegut.");
                }
            } else if (opt == 3) {
                System.out.println("Nom del element a eliminar: ");
                new_element = sc.next();
                sc.nextLine();
                if (ej2.almacen.containsKey(new_element)) {
                    System.out.println("Estàs segur d’esborrar el producte " + new_element + "? S/N\n");
                    String answer = sc.next();
                    if (answer.toLowerCase().equals("s")) {
                        ej2.almacen.remove(new_element);
                    }
                }
            } else if (opt == 4) {
                NavigableSet<String> order = ej2.almacen.descendingKeySet();
                for (String i : order) {
                    System.out.println("Producte: " + i + " Preu: " + ej2.almacen.get(i));
                }
            } else if (opt == 0) {
                close = true;
            }
        }
    }
    public void insertarElemento(String nombre, float precio){
        almacen.put(nombre, precio);
    }
}
