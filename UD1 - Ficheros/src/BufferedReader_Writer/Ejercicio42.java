package BufferedReader_Writer;

import java.io.*;


public class Ejercicio42 {
    public static void main(String[] args) throws IOException {
        // Abro el streams buffereado
        BufferedReader br = new BufferedReader(new FileReader("palabras.txt"));

        // Leo todas las lineas
        String linea;
        int contadorPalabras = 0;

        while((linea = br.readLine())!=null){
            contadorPalabras += linea.split(" |-").length;
        }

        // Cierro el buffer
        br.close();

        System.out.println("Hay "+contadorPalabras+" palabras en el texto");

    }
}
