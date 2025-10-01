package Aleatorios;

import serializacion.Persona;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Ejercicio2_Persona {
    public static void main(String[] args) throws IOException {

        // Genero el ArrayList con personas de ejemplo
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"ana",1.4));
        personas.add(new Persona(4,"teo",4.4));
        personas.add(new Persona(6,"lea",6.4));
        personas.add(new Persona(9,"meo",9.4));

        // Abrir el archivo aleatorio
        RandomAccessFile raf = new RandomAccessFile("personas.data","rw");

        // Calculo del tamaño de una persona
        final int PERSONA_SIZE = 4 + 3*2 + 8; // 4 bytes entero + 3 char * 2 bytes + 8 bytes double

        // Guardo los distintos elementos
        for (Persona persona : personas) {
            // posicionarme donde quiero escribir
            raf.seek(PERSONA_SIZE * persona.getId());

            // Guardo los datos
            raf.writeInt(persona.getId());
            raf.writeChars(persona.getNombre());
            raf.writeDouble(persona.getNota());
        }

        raf.close();

    }

}
