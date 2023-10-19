package Pr14XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.Scanner;

public class Pr142Main {
    static Scanner in = new Scanner(System.in); // System.in és global

    // Main
    public static void main(String[] args) {
        boolean running = true;
        try {
            // Factory constructor documentos
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            // Leer documento
            DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
            // Crear documento
            Document doc = dbuilder.parse("./src/Pr14XML/Archivos/cursos.xml");
            // Crear Xpath
            XPath xPath = XPathFactory.newInstance().newXPath();

            while (running) {
                String menu = "Escull una opció:";
                menu = menu + "\n 0) Llistar ids de cursos, tutors i total d’alumnes";
                menu = menu + "\n 1) Mostrar ids i titols dels mòduls a partir d'un id de curs";
                menu = menu + "\n 2) Llistar alumnes d’un curs";
                menu = menu + "\n 3) Afegir un alumne a un curs";
                menu = menu + "\n 4) Eliminar un alumne d'un curs";
                menu = menu + "\n 100) Sortir";
                System.out.println(menu);
                int opcio = Integer.parseInt(llegirLinia("Opció: "));
                try {
                    switch (opcio) {
                        case 0:
                            listarIDs(doc, xPath);
                            break;
                        case 1:
                            mostrarPorID(doc, xPath);
                            break;
                        case 2: break;
                        case 3: break;
                        case 4: break;
                        case 100:
                            running = false;
                            break;
                        default:
                            System.out.println("Opcio fora de rang.");
                            ;
                    }
                } catch (Exception e) {throw new RuntimeException(e);}
            }
            in.close();
    } catch(Exception e) {e.printStackTrace();}
}
    static public String llegirLinia (String text) {
        System.out.print(text);
        return in.nextLine();
    }
    public static void listarIDs(Document doc, XPath xPath) {
        String expression = "/cursos/curs";
        try {
            NodeList listExpression = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
            for (int element = 0; element < listExpression.getLength(); element++) {
                Element cursoElement = (Element) listExpression.item(element);
                String id = cursoElement.getAttribute("id");
                String tutor = cursoElement.getElementsByTagName("tutor").item(0).getTextContent();
                int numAlumnos = cursoElement.getElementsByTagName("alumne").getLength();

                System.out.println("ID: " + id + "; Tutor: " + tutor + "; Total de Alumnos: " + numAlumnos + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void mostrarPorID(Document doc, XPath xPath) {
        String id = llegirLinia("ID del curs que busques: ");
        String expression = "/cursos/curs[@id='" + id + "']/moduls/modul";
        try {
            NodeList listaModuls = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
            if (listaModuls.getLength() > 0) {
                for (int i = 0; i < listaModuls.getLength(); i++) {
                    Element modulElement = (Element) listaModuls.item(i);
                    String modulID = modulElement.getAttribute("id");
                    String modulTitle = modulElement.getElementsByTagName("titol").item(0).getTextContent();
                    System.out.println("ID del mòdul: " + modulID + ", Títol del mòdul: " + modulTitle);
                }
            } else {System.out.println("El id no existeix.\n");}
        } catch (Exception e) {e.printStackTrace();}
    }
}
