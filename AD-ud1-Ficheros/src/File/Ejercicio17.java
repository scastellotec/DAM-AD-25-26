package File;

import java.io.File;

public class Ejercicio17 {

    //1.7 Dado un directorio muestra el nombre de todos
    // los archivos que contenga, o si está vacío
    public static void main(String[] args) {

        // Instancio el directorio deseado
        String nombreDirectorio = "carpeta12";
        File directorio = new File(nombreDirectorio);

        // Nos aseguramos que es un directorio y existe
        if(directorio.isDirectory()){
            // Necesito listar su contenido:
            String[] listaFicheros = directorio.list();

            if(listaFicheros.length == 0){
                System.out.println("Carpeta vacia");
            }else {
                for (String s : listaFicheros) {
                    System.out.println(s);
                }
            }

        }else{
            System.out.println("Proporciona el nombre de un directorio valido o que exista");
        }
    }
}
