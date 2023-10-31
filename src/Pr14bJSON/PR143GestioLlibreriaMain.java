package Pr14bJSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PR143GestioLlibreriaMain {
    static Scanner in = new Scanner(System.in); // System.in és global
    // Main
    public static void main(String[] args) throws InterruptedException, IOException {
        List<Map<String, Object>> lista_libros = null;

        try {
            System.out.println("-- Leer JSON --");
            lista_libros = lecturaJSON();
            System.out.println("Presiona enter para continuar.");
            in.nextLine();

            System.out.println("-- Modificar datos --");
            lista_libros = modificacio_dades(lista_libros);
            System.out.println("Presiona enter para continuar.");
            in.nextLine();

            System.out.println("-- Añadir datos --");
            lista_libros = afegir_dades(lista_libros);
            System.out.println("Presiona enter para continuar.");
            in.nextLine();

            System.out.println("-- Borrar datos --");
            lista_libros = esborrar_dades(lista_libros);
            System.out.println("Presiona enter para continuar.");
            in.nextLine();

            System.out.println("-- Guardar JSON --");
            guardarJSON(lista_libros);

        } catch (IOException e) {e.printStackTrace();}
        in.close();
    }
    static public List<Map<String, Object>> lecturaJSON() throws IOException{
        // Llegeix el fitxer llibres_input.json i carrega'l a una estructura de dades en memòria.
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> lista_libros = objectMapper.readValue(new File("./src/Pr14bJSON/Archivos/llibres_input.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Map.class));

        for (Map<String, Object> libro : lista_libros){
            System.out.println(libro);
        }
        return lista_libros;
    }
    static public List<Map<String, Object>> modificacio_dades(List<Map<String, Object>> lista_libros){
        // Canvia l'any de publicació del llibre amb id 1 a 1995.
        if (lista_libros != null) {
            for (Map<String, Object> libro : lista_libros) {
                if (libro.get("id").equals(1)) {
                    libro.put("any",1995);
                }
                System.out.println(libro);
            }
        } else {
            System.out.println("Primero tienes que leer el archivo!");
        }
        return lista_libros;
    }
    static public List<Map<String, Object>> afegir_dades(List<Map<String, Object>> lista_libros){
        // Afegeix un nou llibre amb id 4, títol "Històries de la ciutat", autor "Miquel Soler", any 2022.
            // Crear un hashmap con el libro nuevo
            Map<String, Object> libroNuevo = new HashMap<>()
            {{{
                put("id",4);
                put("titol", "Històries de la ciutat");
                put("autor", "Miquel Soler");
                put("any", 2022);
            }}};
            // Añadir el libro a la lista de libros
            lista_libros.add(libroNuevo);
            // Mostrar lista de libros actualizada
            for (Map<String, Object> libro : lista_libros){
                System.out.println(libro);
            }
            return lista_libros;
    }
    static public List<Map<String, Object>> esborrar_dades(List<Map<String, Object>> lista_libros){
        // Esborra el llibre amb id 2.
        lista_libros.removeIf(libro -> libro.get("id").equals(2));
        for (Map<String, Object> libro : lista_libros){
            System.out.println(libro);
        }
        return lista_libros;
    }
    static public void guardarJSON(List<Map<String, Object>> lista_libros) throws IOException{
        // Guarda les dades modificades en un fitxer nou anomenat llibres_output.json.
        ObjectMapper objectMapper = new ObjectMapper();
        // Activar el indent al guardar
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        // Guardar con el indent
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("./src/Pr14bJSON/Archivos/llibres_output.json"), lista_libros);
        System.out.println("Dades guardades amb èxit a llibres_output.json!");
    }
}
