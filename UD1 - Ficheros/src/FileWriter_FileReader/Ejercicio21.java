package FileWriter_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**2.1 Crea un fichero de texto con algún editor de texto
 *  y después realiza una clase de Java que visualice su
 *  contenido. El programa recibe el nombre del archivo en tiempo de ejecución por línea de comandos.
 * */
public class Ejercicio21 {

    public static void main(String[] args) throws IOException {
        // Selecciono el archivo
        String nombreArchivo = "ejempl20.txt";
        FileReader freader = new FileReader(nombreArchivo);

        // Recorro el contenido y lo muestro por pantalla
        int dato;
        while((dato = freader.read()) != -1){
            System.out.print((char)dato);
        }

        // Libero recursos
        freader.close();
    }
}
