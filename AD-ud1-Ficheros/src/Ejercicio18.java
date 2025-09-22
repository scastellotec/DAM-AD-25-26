import java.io.File;

public class Ejercicio18 {
    public static void main(String[] args) {
        // Nombre de la carpeta a mostrar
        String nombreCarpeta = "carpeta12";

        // Doy por hecho que existe y es un directorio
        mostrarContenido(new File(nombreCarpeta));
    }

    static void mostrarContenido(File carpeta){

        // Recibo la carpeta y recojo su contenido
        File[] contenido = carpeta.listFiles();

        // Recorro todo el array
        for(File f: contenido){
            // Determinar si es carpeta o no
            if(f.isDirectory()) {
                // Si es carpeta vuelvo a llamar a esta funcion
                System.out.println("/"+f.getName()+"/");
                mostrarContenido(f);
            }else {
                // Si es fichero muestro su nombre
                System.out.println("-"+f.getName());
            }
        }





    }
}
