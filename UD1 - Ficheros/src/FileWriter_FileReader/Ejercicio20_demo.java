package FileWriter_FileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio20_demo {
    public static void main(String[] args) throws IOException {
        // Abro el streams buffereado
        BufferedWriter bfwriter = new BufferedWriter(new FileWriter("streams1.txt"));

        // Escribo las lineas
        bfwriter.write("Primera prueba del bufferedwriter");
        bfwriter.newLine();
        bfwriter.write("Segunda linea de mi archivo");

        //bfwriter.flush(); // No es necesario porque va implicito en el close()
        // Cierro
        bfwriter.close();
    }
}
