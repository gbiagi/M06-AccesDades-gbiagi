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
            elmPrincipal.setAttribute("id", "001");
            elmRoot.appendChild(elmPrincipal);

            // Crear elementos + la informacion
            Text nodeText;
            Element elmTitulo = doc.createElement("titol");
            nodeText = doc.createTextNode("El viatge del venturons");
            elmTitulo.appendChild(nodeText);
            elmPrincipal.appendChild(elmTitulo);

            Element elmAutor = doc.createElement("autor");
            nodeText = doc.createTextNode("Joan Pla");
            elmAutor.appendChild(nodeText);
            elmPrincipal.appendChild(elmAutor);

            Element elmAny = doc.createElement("anyPublicacio");
            nodeText = doc.createTextNode("1998");
            elmAny.appendChild(nodeText);
            elmPrincipal.appendChild(elmAny);

            Element elmEditorial = doc.createElement("editorial");
            nodeText = doc.createTextNode("Edicions Mar");
            elmEditorial.appendChild(nodeText);
            elmPrincipal.appendChild(elmEditorial);

            Element elmGenere = doc.createElement("genere");
            nodeText = doc.createTextNode("Aventura");
            elmGenere.appendChild(nodeText);
            elmPrincipal.appendChild(elmGenere);

            Element elmPaginas = doc.createElement("pagines");
            nodeText = doc.createTextNode("320");
            elmPaginas.appendChild(nodeText);
            elmPrincipal.appendChild(elmPaginas);

            Element elmDisponible = doc.createElement("disponible");
            nodeText = doc.createTextNode("true");
            elmDisponible.appendChild(nodeText);
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
    }
}
