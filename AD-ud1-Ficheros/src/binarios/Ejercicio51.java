package binarios;

import java.io.*;

public class Ejercicio51 {
    public static void main(String[] args) throws IOException {
        // Creamos un archivo binario
        DataOutputStream dOutput = new DataOutputStream(new FileOutputStream("fichero1.dat"));

        // Escribo datos en el archivo
        dOutput.writeInt(100);
        dOutput.writeBoolean(false);
        dOutput.writeUTF("aula");
        dOutput.writeDouble(10.0);

        // Cierro el archivo
        dOutput.close();

        // Leemos el archivo
        FileInputStream fInput = new FileInputStream("fichero1.dat");

        int dato;
        while((dato = fInput.read()) != -1){
            System.out.print(dato+" ");
        }

        // Cierro
        fInput.close();

    }
}
