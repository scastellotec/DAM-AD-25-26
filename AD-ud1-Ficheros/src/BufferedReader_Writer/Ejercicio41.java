package BufferedReader_Writer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio41 {

    // Crea un método que reciba el nombre de un archivo, y un entero.
    //  El método deberá crear el archivo y escribir ‘n’ líneas dentro.
    //   Cada línea deberá tener escrito “Esta es la línea n”, sustituyendo
    //   ‘n’ por el número de la línea. Utiliza un buffer para realizar
    //   la escritura de forma más eficiente.

    public static void main(String[] args) throws IOException {

        // Numero de lineas deseadas
        int numeroLineas = 10;

        // Buffer de escritura en el archivo
        BufferedWriter bw = new BufferedWriter(new PrintWriter("ejercicio41.txt"));

        // Relleno el archivo con datos
        for(int i=0; i<numeroLineas; i++){
            bw.write("Esta es la linea "+i);
            bw.newLine();
        }

        //Cierro el buffer
        bw.flush();
        //bw.close(); // implica hacer un flush y close


    }
}
