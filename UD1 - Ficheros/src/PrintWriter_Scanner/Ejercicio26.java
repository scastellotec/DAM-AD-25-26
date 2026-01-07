package PrintWriter_Scanner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 2.6 Calcular la media de los números almacenados en un fichero. Cada número está en una línea. El nombre del fichero se pasa como argumento de la línea de comandos

 */
public class Ejercicio26 {
    public static void main(String[] args) throws IOException {

        // Abro el fichero
        Scanner scanner = new Scanner(new File("numeros.txt"));

        // Declaro una colección para almacenar los numeros
        var listaNumeros = new ArrayList<Integer>();

        // Lo recorro
        while(scanner.hasNextLine()){
            listaNumeros.add(Integer.parseInt(scanner.nextLine()));
        }

        // OPCION 1: Calcular media
        int total = 0;
        int size = listaNumeros.size();
        for(Integer a: listaNumeros){
            total += a;
        }
        System.out.println("La media es: "+total/size);

        // OPCION 2: Usando streams
        double media = listaNumeros.parallelStream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("La media usando streams: "+media);

        // Libero recursos
        scanner.close();

        // Guardo el resultado en un fichero
        PrintWriter pWriter = new PrintWriter(new File("media.txt"));
        pWriter.println(media);
        pWriter.close();
    }
}
