package Repository;

import Model.Producto;

import java.io.IOException;
import java.util.List;

public interface ProductoRepository {

    void guardar(Producto producto) throws IOException;

    Producto findByID(int id);

    List<Producto> findAll() throws IOException;

}
