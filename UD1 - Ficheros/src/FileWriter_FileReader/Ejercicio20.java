package FileWriter_FileReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio20 {

    public static void main(String[] args) throws IOException {

        // GENERAMOS EL ARCHIVO Y LO ESCRIBIMOS EN UN FICHERO

        // Datos principales de la aplicacion
        String nombreFichero = "ejempl20.txt";
        String frase = "Hola buenos dias";

        // Instancio un FileWriter para escribir en el fichero de texto
        FileWriter fileWriter = new FileWriter(nombreFichero);

        // Escribo en el archivo la frase deseada
        fileWriter.write(frase);

        // Cierro y libero recursos
        fileWriter.close();

        // LEO EL CONTENIDO DEL FICHERO

        FileReader fileReader = new FileReader(nombreFichero);

        int dato;
        while((dato = fileReader.read()) != -1){
            System.out.print(dato+" ");
        }

        fileReader.close();

    }
}


