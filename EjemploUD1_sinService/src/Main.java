import Model.Jugador;
import Repository.JugadorRepositoryCSV;
import Repository.JugadorRepositoryMemory;
import Service.JugadorService;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Inicio aplicacion");

        //JugadorRepositoryMemory jRepo = new JugadorRepositoryMemory();
        JugadorRepositoryCSV jRepo = new JugadorRepositoryCSV("jugadores.csv");
        JugadorService jService = new JugadorService(jRepo);

        // Meto unos pocos juadores
        jService.guardar(new Jugador(3, "Messi", 10));
        jService.guardar(new Jugador(4, "CR7", 7));
        jService.guardar(new Jugador(5, "Pardeza", 5));

        // Listo los jugadores
        jService.listarTodos().forEach(System.out::println);
    }
}