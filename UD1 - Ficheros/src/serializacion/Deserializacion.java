package serializacion;

import java.io.*;

public class Deserializacion {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Leo objetos serializados del archivo
        ObjectInputStream oInput = new ObjectInputStream(new FileInputStream("serializacion.data"));
        Persona pTemp = (Persona) oInput.readObject();

        // Libero recursos
        oInput.close();

        // Muestro datos por pantalla
        System.out.println(pTemp);
    }
}
