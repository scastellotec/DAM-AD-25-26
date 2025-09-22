package File;

import java.io.File;
import java.util.Scanner;

public class Ejercicio14 {

    public static void main(String[] args) {

        // Recogemos de teclado el nombre de la carpeta
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre de carpeta a crear");
        String nombreCarpeta = sc.nextLine();

        // Instanciamos la carpeta
        File ficheroExiste = new File(nombreCarpeta);

        // La creamos o no en función de lo que devuelva mkdir()
        if(ficheroExiste.mkdir()){
            System.out.println("El directorio se ha creado");
        }else{
            System.out.println("El directorio ya existia");
        }
    }
}
