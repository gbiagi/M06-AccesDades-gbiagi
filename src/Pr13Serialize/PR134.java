package Pr13Serialize;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class PR134 {
    private static final int ID_SIZE = 4; // bytes
    private static final int CHAR_SIZE = 2; // bytes per caràcter en UTF-16
    private static final int NAME_SIZE = 20; // Longitud màxima en caràcters del nom
    private static final int GRADE_SIZE = 4; // bytes

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("./src/Pr13Serialize/Archivos/alumnes.dat", "rw")) {
            ArrayList<Integer> listaIDs = new ArrayList<>();
            boolean showMenu = true;
            // Menu
            while (showMenu) {
                int id;
                float nota;
                Scanner scnr = new Scanner(System.in);
                String menu = "\nEscull una opció:";
                menu = menu + "\n 0) Afegir alumnes exemple";
                menu = menu + "\n 1) Afegir un estudiant";
                menu = menu + "\n 2) Actualitzar nota d'un estudiant";
                menu = menu + "\n 3) Consultar nota d'un estudiant";
                menu = menu + "\n 4) Mostrar tots els alumnes";
                menu = menu + "\n 100) Sortir";
                System.out.println(menu);
                System.out.println("Opcio: ");
                if (scnr.hasNextInt()) {
                    int opcio = scnr.nextInt();
                    switch (opcio) {
                        case 0:
                            try {
                                afegirAlumne(raf, 51, "Joan Potter", 7.5f);
                                afegirAlumne(raf, 52, "Nicolas Rana", 5.8f);
                                afegirAlumne(raf, 53, "Daniel Ramos", 8f);
                                afegirAlumne(raf, 54, "Xavi Gil", 10f);
                            } catch (Exception e) {
                                System.out.println("Error al afegir els alumnes.");
                            }
                            break;
                        case 1:
                            id = validInputInt(scnr);
                            String name = validName(scnr);
                            nota = validInputFloat(scnr);
                            afegirAlumne(raf, id, name, nota);
                            System.out.println("Alumne afegit!");
                            break;
                        case 2:
                            id = validInputInt(scnr);
                            try {
                                mostrarAlumne(raf,id);
                            } catch (Exception e) {
                                System.out.println("L'alumne no existeix\n");
                                break;}
                            nota = validInputFloat(scnr);
                            actualitzarNota(raf, id, nota);
                            System.out.println("Nota de l'alumne actualitzada.");
                            break;
                        case 3:
                            id = validInputInt(scnr);
                            try{
                                mostrarAlumne(raf,id);
                            } catch (Exception e) {
                                System.out.println("L'alumne no existeix\n");}
                            break;
                        case 4:
                            mostrarTotalAlumnes(raf);
                            break;
                        case 100:
                            showMenu = false;
                        default: break;
                    }
                } else {
                    System.out.println("Introdueix un numero");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obrir l'arxiu.");;
        }
    }

    public static String validName(Scanner scanner) {
        while (true) {
            System.out.println("Introdueix el nom de l'alumne: ");
            String name = scanner.next();
            if (!name.equals("")) {
                return name;
            } else {
                System.out.println("Has de introduïr un nom.");
            }
        }
    }
    public static int validInputInt (Scanner scanner) {
        while (true) {
            System.out.println("Introdueix el numero ID de l'alumne: ");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Has de introduïr un numero.");
            }
        }
    }
    public static float validInputFloat (Scanner scanner) {
        while (true) {
            System.out.println("Introdueix la nova nota de l'alumne: ");
            if (scanner.hasNextFloat()) {
                return scanner.nextFloat();
            } else {
                System.out.println("Has de introduïr un numero.");
            }
        }
    }
    public static void mostrarTotalAlumnes (RandomAccessFile raf){
        try {
            long fileLength = raf.length();
            long totalAlumnes = fileLength / (ID_SIZE + NAME_SIZE * CHAR_SIZE + GRADE_SIZE);

            // Imprimir tots el alumnes
            for (int id = 1; id <= totalAlumnes; id++) {
                System.out.println("Alumne: "+ id + " " + consultarNomAlumne(raf, id) + " Nota: " + consultarNotaAlumne(raf, id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void afegirAlumne(RandomAccessFile raf, int id, String nom, float nota) throws Exception {
        raf.seek(raf.length());
        raf.writeInt(id);
        raf.writeChars(getPaddedName(nom));
        raf.writeFloat(nota);
    }

    public static String consultarNomAlumne(RandomAccessFile raf, int id) throws Exception {
        raf.seek(getSeekPosition(id));
        raf.readInt();
        char[] chars = new char[NAME_SIZE];
        for (int i = 0; i < NAME_SIZE; i++) {
            chars[i] = raf.readChar();
        }
        return new String(chars);
    }

    public static float consultarNotaAlumne(RandomAccessFile raf, int id) throws Exception {
        raf.seek(getSeekPosition(id) + ID_SIZE + NAME_SIZE * CHAR_SIZE);
        return raf.readFloat();
    }

    public static void actualitzarNota(RandomAccessFile raf, int id, float nota) throws Exception {
        raf.seek(getSeekPosition(id) + ID_SIZE + NAME_SIZE * CHAR_SIZE);
        raf.writeFloat(nota);
    }

    public static void mostrarAlumne(RandomAccessFile raf, int id) throws Exception {
        System.out.println(
                "Alumne " + id + ": " + consultarNomAlumne(raf, id) + " Nota: " + consultarNotaAlumne(raf, id));
    }

    private static long getSeekPosition(int id) {
        // L'operació (id - 1) serveix per obtenir un índex basat en 0.
        // (ID_SIZE + NAME_SIZE * CHAR_SIZE + GRADE_SIZE) calcula la mida total en bytes
        // d'un registre.
        // ID_SIZE representa la mida en bytes de l'ID.
        // NAME_SIZE * CHAR_SIZE representa la mida total en bytes del nom.
        return (id - 1) * (ID_SIZE + NAME_SIZE * CHAR_SIZE + GRADE_SIZE);
    }

    private static String getPaddedName(String name) {
        // Si el nom és més llarg que la mida màxima permesa (NAME_SIZE),
        // es trunca per ajustar-se a aquesta mida.
        if (name.length() > NAME_SIZE) {
            return name.substring(0, NAME_SIZE);
        }
        // Si el nom és més curt que NAME_SIZE, s'omple amb espais en blanc fins a
        // assolir aquesta mida.
        // String.format amb "%1$-" + NAME_SIZE + "s" assegura que la cadena resultant
        // tingui una longitud fixa.
        return String.format("%1$-" + NAME_SIZE + "s", name);
    }
}
