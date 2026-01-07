package Repository;

import java.util.List;

public interface BaseRepository<T,K> {

    List<T> findAll();
    T findById(int id);
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(K id);

}
