package Repository;

import Model.Categoria;
import Model.Producto;

import java.util.List;

public interface ProductoBaseRepository<P, L extends Number> extends BaseRepository{

    List<Producto> findByCategory(Categoria c);
}
