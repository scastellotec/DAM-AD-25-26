package Service;

import Model.Jugador;
import Repository.JugadorRepositoryCSV;
import Repository.JugadorRepositoryMemory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JugadorService {

    JugadorRepositoryCSV jrepo;

    public JugadorService(JugadorRepositoryCSV jrepo) {
        this.jrepo = jrepo;
    }

    public void guardar(Jugador j) throws IOException {
        //valiar que el id no existe
        List<Jugador> jugadores = listarTodos();
        boolean existeID = false;
        for(Jugador jtemp: jugadores){
            if(jtemp.getId() == j.getId())
                existeID = true;
        }

        if(!existeID)
            jrepo.guardar(j);
        else
            System.out.println("ID ya existente");
    }

    public List<Jugador> listarTodos() throws FileNotFoundException {
        return jrepo.listarTodos();
    }
}
