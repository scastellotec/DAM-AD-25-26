package Repository;

import Model.Jugador;

import java.util.ArrayList;
import java.util.List;

public class JugadorRepositoryMemory {

    private List<Jugador> jugadores;

    public JugadorRepositoryMemory() {
        this.jugadores = new ArrayList<Jugador>();
    }

    public void guardar(Jugador j) {
        jugadores.add(j);
    }

    public List<Jugador> listarTodos(){
        return jugadores;
    }
}
