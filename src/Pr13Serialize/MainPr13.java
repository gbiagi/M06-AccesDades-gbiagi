package Pr13Serialize;

import java.io.IOException;
import java.util.Scanner;

public class MainPr13 {
    static Scanner in = new Scanner(System.in); // System.in és global
    // Main
    public static void main(String[] args) throws InterruptedException, IOException {
        boolean running = true;
        while (running) {
            String menu = "Escull una opció:";
            menu = menu + "\n 0) PR131Escriu";
            menu = menu + "\n 1) PR131Llegeix";
            menu = menu + "\n 2) PR132main";
            menu = menu + "\n 100) Sortir";
            System.out.println(menu);
            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            try {
                switch (opcio) {
                    case 0: PR131mainEscriu.main(args); break;
                    case 1: PR131mainLlegeix.main(args); break;
                    case 2: Pr132main.main(args); break;
                    case 3: PR133mainTreballadors.main(args); break;
                    case 100: running = false; break;
                    default: break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        in.close();
    }
    static public String llegirLinia (String text) {
        System.out.print(text);
        return in.nextLine();
    }
}