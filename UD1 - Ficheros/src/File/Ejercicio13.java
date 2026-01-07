package File;

import java.io.File;
import java.io.IOException;

public class Ejercicio13 {
    public static void main(String[] args) throws IOException {
        File ficheroExiste = new File("ejercicio13.txt");

        if(ficheroExiste.createNewFile()){
            System.out.println("El fichero se ha creado");
        }else{
            System.out.println("El fichero ya existia");
        }
    }
}
