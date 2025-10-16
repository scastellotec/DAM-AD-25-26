package ficherosXML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        // Escribimos el XML con los datos de los jugadores
        // ESTO ES UN EJEMPLO HECHO A MANO

        // Creo los elementos necesarios para crear el archivo XML en memoria
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        // Generar la estructura y el contenido del archivo
        Element raiz = doc.createElement("equipo");

        // Generar elementos nuevos
        Element jugador1 = doc.createElement("jugador");
        Element id1 = doc.createElement("id");
        Element nombre1 = doc.createElement("nombre");
        Element puntos1 = doc.createElement("puntos");

        // insertar texto dentro de elementos
        id1.appendChild(doc.createTextNode("23"));
        nombre1.setTextContent("Mariano");

        // Crear un atributo y lo añado a un elemento
        Attr dorsal = doc.createAttribute("dorsal");
        dorsal.setValue("10");
        jugador1.setAttributeNode(dorsal);

        // Crear estructura de nodos padremadres-hijohija
        jugador1.appendChild(id1);
        jugador1.appendChild(nombre1);
        jugador1.appendChild(puntos1);
        raiz.appendChild(jugador1);

        doc.appendChild(raiz);

        // GENERANDO EL XML MEDIANTE BUCLES
        // Partimos de un ArrayList de ejemplo
        ArrayList<Jugadores> jugadores = new ArrayList<>();
        jugadores.add(new Jugadores(1, "Edurne",40.3));
        jugadores.add(new Jugadores(2, "Eduardo",50.3));
        jugadores.add(new Jugadores(3, "Lourdes",60.3));
        jugadores.add(new Jugadores(4, "Javier",70.3));

        // Ya tenemos el nodo raiz creado del ejercicio anterior

        // Por cada jugador hare lo siguiente
        for (Jugadores j: jugadores){
            // Crear el elemnto jugador y sus hijos
            jugador1 = doc.createElement("jugador");
            dorsal = doc.createAttribute("id");
            nombre1 = doc.createElement("nombre");
            puntos1 = doc.createElement("puntos");

            // Darles valores
            dorsal.setValue(String.valueOf(j.getId()));
            nombre1.setTextContent(j.getNombre());
            puntos1.setTextContent(String.valueOf(j.getPuntos()));

            // Crear la estructura
            jugador1.appendChild(nombre1);
            jugador1.appendChild(puntos1);
            jugador1.setAttributeNode(dorsal);

            // Añadirlo al nodo padre
            raiz.appendChild(jugador1);
        }


        // Finalizar la creación del archivo XML y transformarlo a archivo
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("jugadores.xml"));
        transformer.transform(source, result);



        // Aqui vamos a hacer la lectura del XML
        ArrayList<Jugadores> jugadoresLeidos = new ArrayList<>();

        // Instancio las librerias necesarias para la lectura de XML
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document docLectura = dBuilder.parse(new File("jugadores.xml"));

        NodeList nList = doc.getElementsByTagName("jugador");
        System.out.println("Número de jugador: " + nList.getLength());

        for (int i=0; i<nList.getLength(); i++){
            Node unNodoHijo = nList.item(i);
            Element e = (Element) unNodoHijo;
            System.out.println(e.getTagName("id") );
        }













    }
}
