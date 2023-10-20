package Pr14XML;

import Pr13Serialize.*;

import java.io.IOException;
import java.util.Scanner;

public class MainPr14 {
    static Scanner in = new Scanner(System.in); // System.in és global
    // Main
    public static void main(String[] args) throws InterruptedException, IOException {
        boolean running = true;
        while (running) {
            String menu = "Escull una opció:";
            menu = menu + "\n 0) PR140Main";
            menu = menu + "\n 1) ";
            menu = menu + "\n 2) ";
            menu = menu + "\n 3) ";
            menu = menu + "\n 4) ";
            menu = menu + "\n 100) Sortir";
            System.out.println(menu);
            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            try {
                switch (opcio) {
                    case 0: PR140Main.main(args); break;
                    case 1: PR141Main.main(args); break;
                    case 2: Pr142Main.main(args); break;
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
