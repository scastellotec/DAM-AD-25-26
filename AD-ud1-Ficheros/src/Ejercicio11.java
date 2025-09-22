import java.io.File;

public class Ejercicio11 {
    public static void main(String[] args) {
        String edad = args[0];
        String nombre = args[1];

        // 1.1 Instancia un fichero y determina si existe o no existe.
        // Muestra su nombre, longitud y ruta absoluta
        File archivo1 = new File("ejemplo1.txt");

        if(archivo1.exists()){
            System.out.println("Archivo existe");
            System.out.println("Nombre: "+archivo1.getName());
            System.out.println("Longitud: "+archivo1.length());
            System.out.println("Ruta: "+archivo1.getAbsolutePath());
        }else{
            System.out.println("Archivo no existe");
        }

    }
}
