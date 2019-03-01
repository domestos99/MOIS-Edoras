package cz.uhk.mois.edoras.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.domain.IDbEntity;

public interface IRepositoryBase<T extends IDbEntity>
{
    int count();

    //boolean existsById(String id);
    List<T> findAll();

    Optional<T> findById(String id);

    T save(T entity);

    List<T> saveAll(List<T> entities);

    boolean delete(T entity);

    // void deleteAll();
    boolean deleteById(String id);

}
