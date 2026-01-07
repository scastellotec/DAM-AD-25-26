package Aleatorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {

        // Creo el archivo
        RandomAccessFile raf = new RandomAccessFile("aleatorio.rand", "rw");

        // Relleno el archivo con numeros del 0 al 9
        for(int i =0; i<10; i++){
            raf.writeInt(i);
        }

        //Composición bit a bit del fichero generado
        // Cada entero escrito ocupa 4 bytes
        //0-3:   (num=0) 00000000 00000000 00000000 00000000
        //4-7:   (num=1) 00000000 00000000 00000000 00000001
        //8-11:  (num=2) 00000000 00000000 00000000 00000010
        //12-15: (num=3) 00000000 00000000 00000000 00000011
        //16-19: (num=4) 00000000 00000000 00000000 00000100
        //20-23: (num=5) 00000000 00000000 00000000 00000101
        //24-27: (num=6) 00000000 00000000 00000000 00000110
        //28-31: (num=7) 00000000 00000000 00000000 00000111
        //32-35: (num=8) 00000000 00000000 00000000 00001000
        //36-39: (num=9) 00000000 00000000 00000000 00001001

        // Indico la posicion donde empiezo a leer
        raf.seek(13);

        // Recupero el numero que quiero leer
        int numeroLeido = raf.readInt();
        System.out.println("Numero leido: "+numeroLeido);

        // Libero recursos
        raf.close();

    }
}
