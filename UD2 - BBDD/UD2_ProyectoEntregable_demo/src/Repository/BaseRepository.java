package Repository;

import java.util.List;

public interface BaseRepository<T, K> {
    void save(T t);
    List<T> findAll();
    T finById(K k);
    void delete(K k);
    T modify(T t);
}
