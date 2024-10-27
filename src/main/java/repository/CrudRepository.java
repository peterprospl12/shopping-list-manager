package repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E, K> {
    Optional<E> findById(K id);

    List<E> findAll();

    E save(E entity);

    void deleteById(E id);
}
