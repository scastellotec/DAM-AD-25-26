package FileWriter_FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 2.4 Escribe una clase Java que pida una serie de frases
 * por teclado hasta que se inserte como frase la palabra “fin”.
 * Dichas frases deberán guardarse en un fichero de texto
 * . A continuación, el programa visualizará el contenido del
 * fichero, frase por frase.

 */
public class Ejercicio24 {
    public static void main(String[] args) throws IOException {

        //Datos principales
        String nombreArchivo = "ejercicio24.txt";
        FileWriter fWriter = new FileWriter(nombreArchivo);
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe lo que quieras, fin para salir: ");

        // Recupero las lineas del usuario y las grabo hasta que ponga "fin"
        String fraseUsuario = sc.nextLine();
        while(!fraseUsuario.equals("fin")){
            // Guardo en fichero
            fWriter.write(fraseUsuario+"\r\n");
            // Volvemos a leer
            fraseUsuario = sc.nextLine();
        }

        // Cierro archivo
        fWriter.close();

        // Muestro contenido de archivo
    }
}
