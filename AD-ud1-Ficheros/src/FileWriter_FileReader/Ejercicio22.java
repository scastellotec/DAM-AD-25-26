package FileWriter_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 2.2 Crea una clase de Java que permita buscar una vocal
 * en un fichero de texto y muestre el número de veces que se repite.
 */
public class Ejercicio22 {
    public static void main(String[] args) throws IOException {

        // Selecciono y abro el archivo
        String nombreArchivo = "ejempl20.txt";
        char vocal = 'a';
        //char vocalMayus = 'A';
        int numeroVeces = 0;
        FileReader freader = new FileReader(nombreArchivo);

        // Recorro el archivo y cuento lo que tenga que contar
        int dato;
        while((dato = freader.read()) != -1){
            char datoNormalizado = Character.toLowerCase((char)dato);
            if(vocal == datoNormalizado)
                numeroVeces++;
        }

        // Libero recursos
        freader.close();

        // Muestro resultado
        System.out.println("Numero de veces "+vocal+": "+numeroVeces);
    }
}
