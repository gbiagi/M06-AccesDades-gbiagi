package Pr14XML;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class PR141Main {
    public static void main(String[] args) {
        try {
            // Factory constructor documentos
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            // Constructor documentos
            DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
            // Crear documento
            Document doc = dbuilder.newDocument();
            // Crear elemento raiz
            Element elmRoot = doc.createElement("biblioteca");
            // Añadir la raiz al xml
            doc.appendChild(elmRoot);
            // Crear element principal
            Element elmPrincipal = doc.createElement("llibre");
            // Crear atributo
            //Attr atrbID = doc.createAttribute("001");
            elmPrincipal.setAttribute("id", "001");
            elmRoot.appendChild(elmPrincipal);

            // Crear elementos + la informacion
            Element elmTitulo = doc.createElement("titol");
            Text nodeText1 = doc.createTextNode("El viatge del venturons");
            elmTitulo.appendChild(nodeText1);
            elmPrincipal.appendChild(elmTitulo);

            Element elmAutor = doc.createElement("autor");
            Text nodeText2 = doc.createTextNode("Joan Pla");
            elmAutor.appendChild(nodeText2);
            elmPrincipal.appendChild(elmAutor);

            Element elmAny = doc.createElement("anyPublicacio");
            Text nodeText3 = doc.createTextNode("1998");
            elmAny.appendChild(nodeText3);
            elmPrincipal.appendChild(elmAny);

            Element elmEditorial = doc.createElement("editorial");
            Text nodeText4 = doc.createTextNode("Edicions Mar");
            elmEditorial.appendChild(nodeText4);
            elmPrincipal.appendChild(elmEditorial);

            Element elmGenere = doc.createElement("genere");
            Text nodeText5 = doc.createTextNode("Aventura");
            elmGenere.appendChild(nodeText5);
            elmPrincipal.appendChild(elmGenere);

            Element elmPaginas = doc.createElement("pagines");
            Text nodeText6 = doc.createTextNode("320");
            elmPaginas.appendChild(nodeText6);
            elmPrincipal.appendChild(elmPaginas);

            Element elmDisponible = doc.createElement("disponible");
            Text nodeText7 = doc.createTextNode("true");
            elmDisponible.appendChild(nodeText7);
            elmPrincipal.appendChild(elmDisponible);

            // Guardar datos en un xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("./src/Pr14XML/Archivos/biblioteca.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {e.printStackTrace();}
    }}
