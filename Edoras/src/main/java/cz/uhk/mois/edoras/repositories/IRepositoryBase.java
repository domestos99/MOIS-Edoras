package cz.uhk.mois.edoras.repositories;

import java.util.ArrayList;
import java.util.Optional;

import cz.uhk.mois.edoras.domain.IDbEntity;

public interface IRepositoryBase<T extends IDbEntity>
{
    int count();

    //boolean existsById(String id);
    ArrayList<T> findAll();

    Optional<T> findById(String id);

    T save(T entity);

    ArrayList<T> saveAll(ArrayList<T> entities);

    boolean delete(T entity);

    // void deleteAll();
    boolean deleteById(String id);

}
