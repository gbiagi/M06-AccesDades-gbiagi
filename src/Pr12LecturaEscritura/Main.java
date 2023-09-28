package Pr12LecturaEscritura;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Main {
    static Scanner in = new Scanner(System.in); // System.in és global
    // Main
    public static void main(String[] args) throws InterruptedException, IOException {
        boolean running = true;
        // Crear carpeta para los archivos por si se elimina
        File dirName = new File("./src/Pr12LecturaEscritura/Archivos");
        // Crear carpeta
        if (!dirName.exists()){
            if(!dirName.mkdirs()) {
                System.out.println("Error en la creació de la carpeta '" + dirName + "'");
            } else {
                System.out.println("Carpeta creada");
            }
        }
        while (running) {
            String menu = "Escull una opció:";
            menu = menu + "\n 0) PR120ReadFile";
            menu = menu + "\n 1) PR121Files";
            menu = menu + "\n 2) PR122cat";
            menu = menu + "\n 3) Pr123append";
            menu = menu + "\n 4) PR123Sobreescriu";
            menu = menu + "\n 5) PR124Linies";
            menu = menu + "\n 6) PR125Copy File";
            menu = menu + "\n 100) Sortir";
            System.out.println(menu);

            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            try {
                switch (opcio) {
                    case 0: PR120ReadFile.main(args); break;
                    case 1: PR121Files.main(args); break;
                    case 2: PR122cat.main(llegirLinia("Ruta del arxiu: ")); break;
                    case 3: PR123append.main(args); break;
                    case 4: PR123sobreescriu.main(args); break;
                    case 5: PR124linies.main(args); break;
                    case 6: PR125cp.main(llegirLinia("Ruta archiu a copiar: "), llegirLinia("Ruta destinacio: ")); break;
                    case 7: llegirLinia("Hola David");
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

