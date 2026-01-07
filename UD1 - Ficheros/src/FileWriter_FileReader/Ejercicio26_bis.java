package FileWriter_FileReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio26_bis {
    public static void main(String[] args) throws IOException {
        {

            // Abro el fichero
            FileReader fr = new FileReader("numeros.txt");

            // Declaro una colección para almacenar los numeros
            var listaNumeros = new ArrayList<Integer>();

            // Lo recorro
            int dato;
            StringBuilder sb = new StringBuilder();

            while((dato = fr.read()) !=-1){
                if (dato == '\n' || dato == '\r') {
                    if (sb.length() > 0) { // si hay número acumulado
                        int numero = Integer.parseInt(sb.toString());
                        listaNumeros.add(numero);
                        sb.setLength(0); // limpiar para la siguiente línea
                    }
                } else {
                    sb.append((char)dato); // acumular el dígito
                }
            }

            System.out.println("Numeros guardados");
            for (Integer listaNumero : listaNumeros) {
                System.out.println(listaNumero);

            }

            // Invocamos a la otra opcion
            ej2f("numeros.txt");

        }
    }


    // Solucion que nos proporciona Tomas
    public static void ej2f(String nombre) {
        try {
            FileReader fr = new FileReader(nombre);
            int letra;
            int total = 0;
            int counter = 0;
            String linea = "";
            do {
                letra = fr.read();
                if (Character.isDigit((char)letra)) {
                    linea += String.valueOf((char)letra);
                } else if (!linea.isEmpty()) {
                    total+=Integer.parseInt(linea);
                    counter++;
                    System.out.println(linea);
                    linea = "";
                }
            } while(letra != -1);
            fr.close();
            System.out.println("Cantidad de numeros: "+counter);
            System.out.println("Total de suma: "+total);
            System.out.println("Promedio: "+(double)total/counter);
        } catch (Exception e) {

        }
    }
}
