package Pr14XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class PR140Main {
    public static void main(String[] args) {
        try {
            // Abrir archivo
            File file = new File("./src/Pr14XML/Archivos/persones.xml");
            // Factory constructor documentos
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            // Constructor documentos
            DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
            // Analizar documento
            Document doc = dbuilder.parse(file);
            // Normaliza el elemento raiz
            doc.getDocumentElement().normalize();
            // Obtener lista del elemento
            NodeList listaPersonas = doc.getElementsByTagName("persona");

            // Imprimir les dades de cada persona
            for (int i = 0; i < listaPersonas.getLength(); i++) {
                // Obtener la persona actual
                Node persona = listaPersonas.item(i);
                if (persona.getNodeType() == Node.ELEMENT_NODE) {
                    Element elm = (Element) persona;
                    NodeList elmList = elm.getElementsByTagName("nom");
                    String nombre = elmList.item(0).getTextContent();
                    elmList = elm.getElementsByTagName("cognom");
                    String apellido = elmList.item(0).getTextContent();
                    elmList = elm.getElementsByTagName("edat");
                    String edad = elmList.item(0).getTextContent();
                    elmList = elm.getElementsByTagName("ciutat");
                    String ciudad = elmList.item(0).getTextContent();
                    String data = "Persona " + (i+1) +
                            "\nNom: " + nombre +
                            "\nCognom: " + apellido +
                            "\nEdat: " + edad +
                            "\nCiutat: " + ciudad + "\n";
                    System.out.println(data);
                }
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}
