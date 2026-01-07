package Repository.impl;

import Model.Jugador;
import Repository.BaseRepository;

import java.sql.Connection;
import java.util.List;

public class JugadorJDBC implements BaseRepository<Jugador, Integer> {

    private final Connection connection;

    public JugadorJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Jugador> findAll() {
        return List.of();
    }

    @Override
    public Jugador findById(int id) {
        return null;
    }

    @Override
    public boolean save(Jugador entity) {
        return false;
    }

    @Override
    public boolean update(Jugador entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
