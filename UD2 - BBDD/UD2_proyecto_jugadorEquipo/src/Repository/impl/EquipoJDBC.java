package Repository.impl;

import Model.Equipo;
import Repository.BaseRepository;

import java.util.List;

public class EquipoJDBC implements BaseRepository<Equipo, Integer> {
    @Override
    public List<Equipo> findAll() {

        return List.of();
    }

    @Override
    public Equipo findById(int id) {
        return null;
    }

    @Override
    public boolean save(Equipo entity) {
        return false;
    }

    @Override
    public boolean update(Equipo entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
