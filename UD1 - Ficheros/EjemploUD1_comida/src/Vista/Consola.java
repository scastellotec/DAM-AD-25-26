package Vista;

import Model.Producto;
import Service.ProductoService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Consola {

    // Atributo requerido: servicio de productos con crearNuevo y listarTodos
    private final ProductoService pService;

    public Consola(ProductoService pService) {
        this.pService = pService;
    }

    public void iniciar() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;
            do {
                mostrarMenu();
                opcion = leerEntero(sc, "Elige opción: ");
                switch (opcion) {
                    case 1 -> anadirProducto(sc);
                    case 2 -> listarProductos();
                    case 0 -> System.out.println("Saliendo... ¡Hasta luego!");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarMenu() {
        System.out.println("\n===== MENÚ PRODUCTOS =====");
        System.out.println("1) Añadir producto");
        System.out.println("2) Listar productos");
        System.out.println("0) Salir");
    }

    private void anadirProducto(Scanner sc) throws IOException {
        System.out.println("\n-- Nuevo producto --");
        int id = leerEntero(sc, "Id (int): ");

        System.out.print("Nombre (String): ");
        String nombre = sc.nextLine().trim();

        double precio = leerDouble(sc, "Precio (double): ");

        Producto p = new Producto(id, nombre, precio);
        pService.crearNuevo(p);
        System.out.println("✅ Producto añadido.");
    }

    private void listarProductos() throws IOException {
        System.out.println("\n-- Listado de productos --");
        List<Producto> lista = pService.mostrarTodos();
        if (lista.isEmpty()) {
            System.out.println("(sin productos)");
            return;
        }
        lista.forEach(System.out::println);
    }

    // Helpers robustos para leer numéricos desde consola:
    private int leerEntero(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("❌ Debe ser un número entero. Inténtalo de nuevo.");
            }
        }
    }

    private double leerDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String linea = sc.nextLine().trim().replace(",", "."); // admite coma decimal
            try {
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                System.out.println("❌ Debe ser un número decimal. Inténtalo de nuevo.");
            }
        }
    }

}
