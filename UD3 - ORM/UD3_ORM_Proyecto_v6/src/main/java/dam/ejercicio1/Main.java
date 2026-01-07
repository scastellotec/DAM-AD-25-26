package dam.ejercicio1;


import dam.ejercicio1.service.TareaService;
import dam.ejercicio1.service.UsuarioService;
import dam.ejercicio1.util.JPAUtil;


public class Main {

    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        TareaService tareaService = new TareaService();

        var u1 = usuarioService.crearUsuario("Sergio", "sergio@correo.com");
        var u2 = usuarioService.crearUsuario("Ana", "ana@correo.com");

        usuarioService.asignarTarea(u1.getId(), "Preparar examen ORM");
        usuarioService.asignarTarea(u1.getId(), "Corregir prácticas");
        usuarioService.asignarTarea(u2.getId(), "Revisar apuntes");

        System.out.println("\n--- Usuarios ---");
        usuarioService.listarUsuarios().forEach(System.out::println);

        System.out.println("\n--- Tareas de Sergio ---");
        tareaService.listarPorUsuario(u1.getId()).forEach(System.out::println);

        System.out.println("\n--- Todas las tareas ---");
        tareaService.listarTodas().forEach(System.out::println);

        // Cierre de la factoría
        JPAUtil.shutdown();
    }
}

