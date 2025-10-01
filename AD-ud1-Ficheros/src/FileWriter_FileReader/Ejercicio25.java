package FileWriter_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 2.5 Una clase que dado un archivo .java cambie los tabuladores por 2 espacios (\t es un tabulador)
 */
public class Ejercicio25 {
    public static void main(String[] args) throws IOException {

        // Abro este archivo en modo LECTURA
        FileReader fReader = new FileReader("ejempl20_original.txt");
        // Abro otro archivo en modo ESCRITURA
        FileWriter fWriter = new FileWriter("ejempl20_nuevo.txt");

        // Recorro el archivo de lectura
        int letra;
        while((letra=fReader.read())!= -1){
            // Detectamos que es un tabulador
            if(letra==9){
                letra = ' ';
                fWriter.write(letra);
                fWriter.write(letra);
                fWriter.write(letra);
            }
            fWriter.write(letra);
        }

        // Cierro el stream de lectura
        fReader.close();
        fWriter.close();

    }
}
