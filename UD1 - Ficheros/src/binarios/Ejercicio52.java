package binarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio52 {
    public static void main(String[] args) throws IOException {
        // Leemos el archio binario del ejercicio anterior
        DataInputStream dInput = new DataInputStream(new FileInputStream("fichero1.dat"));

        // Leo el fichero binario
        int numero = dInput.readInt();
        boolean b = dInput.readBoolean();
        String palabra = dInput.readUTF();
        double num2 = dInput.readDouble();

        // Muestro por pantalla los datos
        System.out.println("Numero entero: "+numero);
        System.out.println("Boleano: "+b);
        System.out.println("Palabra: "+palabra);
        System.out.println("Numero double: "+num2);

        // Cierro flujos
        dInput.close();

    }
}
