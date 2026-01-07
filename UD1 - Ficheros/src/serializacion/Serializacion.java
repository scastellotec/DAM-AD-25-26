package serializacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializacion {
    public static void main(String[] args) throws IOException {
        // Creo el objeto persona
        Persona p = new Persona(23,"Julian",9.75);

        // Lo serializo
        ObjectOutputStream oOutput = new ObjectOutputStream(new FileOutputStream("serializacion.data"));
        oOutput.writeObject(p);

        // Libero recursos
        oOutput.close();
    }
}
