import java.io.File;
import java.util.Scanner;

public class Ejercicio15_16 {
    public static void main(String[] args) {

        // Recogemos de teclado el nombre del fichero a borrar
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre del archivo a borrar");
        String nombreFichero = sc.nextLine();

        File fichero = new File(nombreFichero);
        if(fichero.delete()){
            System.out.println("Borrado correctamente");
        }else{
            System.out.println("No habia nada que borrar");
        }

    }
}
