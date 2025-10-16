package Repository;

import Model.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JugadorRepositoryCSV {

    private String nombreArchivo;

    public JugadorRepositoryCSV(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardar(Jugador j) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo, true));
        pw.println(j.getId()+","+j.getNombre()+","+j.getDorsal());
        pw.close();
    }

    public List<Jugador> listarTodos() throws FileNotFoundException {
        List<Jugador> jugadores = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader(nombreArchivo));

        while(sc.hasNextLine()){
            String[] datos = sc.nextLine().split(",");
            jugadores.add(new Jugador(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2])));
        }

        sc.close();
        return jugadores;

    }
}
