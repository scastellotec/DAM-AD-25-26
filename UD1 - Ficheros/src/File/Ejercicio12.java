package File;

import java.io.File;

public class Ejercicio12 {

    /*
    1.2 Instancia un directorio y determina si existe o no existe.
     Muestra su nombre, longitud y ruta absoluta

     */
    public static void main(String[] args) {
        File directorio = new File("carpeta12");

        if(directorio.exists()){
            System.out.println("La carpeta existe");
            System.out.println("Nombre: "+directorio.getName());
            System.out.println("Longitud: "+directorio.length());
            System.out.println("Ruta: "+directorio.getAbsolutePath());
        }else{
            System.out.println("La carpeta NO existe");
        }
    }
}
