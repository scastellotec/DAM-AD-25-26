package Repository.impl;

import Model.Categoria;
import Model.Producto;
import Repository.ProductoBaseRepository;

import java.util.List;

public class ProductoRepositoryJDBC implements ProductoBaseRepository<Producto, Long> {

    @Override
    public List<Producto> findByCategory(Categoria c) {
        return List.of();
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public List findAll() {
        return List.of();
    }

    @Override
    public Object finById(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public Object modify(Object o) {
        return null;
    }
}
