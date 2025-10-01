package Aleatorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio3_lecturaPesona {

    public static void main(String[] args) throws IOException {

        // Abrir el archivo aleatorio
        RandomAccessFile raf = new RandomAccessFile("personas.data","r");

        // Recupero datos de una persona
        // Buscamos a la persona numero 6 sabiendo que cada una ocupa 16 bytes
        raf.seek(18*6);

        System.out.println("id: "+raf.readInt());
        System.out.println("nombre: "+raf.readChar()+raf.readChar()+raf.readChar());
        System.out.println("nota: "+raf.readDouble());

        // libero recursos
        raf.close();
    }
}
