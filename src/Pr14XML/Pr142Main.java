package Pr14XML;

import java.io.IOException;
import java.util.Scanner;

public class Pr142Main {
    static Scanner in = new Scanner(System.in); // System.in és global
    // Main
    public static void main(String[] args) throws InterruptedException, IOException {
        boolean running = true;
        while (running) {
            String menu = "Escull una opció:";
            menu = menu + "\n 0) Llistar ids de cursos, tutors i total d’alumnes";
            menu = menu + "\n 1) Mostrar ids i titols dels mòduls a partir d'un id de curs";
            menu = menu + "\n 2) Llistar alumnes d’un curs";
            menu = menu + "\n 3) Afegir un alumne a un curs";
            menu = menu + "\n 4) Eliminar un alumne d'un curs";
            menu = menu + "\n 100) Sortir";
            System.out.println(menu);
            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            try {
                switch (opcio) {
                    case 0: PR140Main.main(args); break;
                    //                        case 1: .main(args); break;
                    //                        case 2: .main(args); break;
                    //                        case 3: .main(args); break;
                    //                        case 4: .main(args); break;
                    case 100: running = false; break;
                    default:
                        System.out.println("Opcio fora de rang.");;
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
