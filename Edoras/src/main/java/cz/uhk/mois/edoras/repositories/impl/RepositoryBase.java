package cz.uhk.mois.edoras.repositories.impl;

import java.util.ArrayList;
import java.util.Optional;

import cz.uhk.mois.edoras.domain.IDbEntity;
import cz.uhk.mois.edoras.repositories.IRepositoryBase;

public abstract class RepositoryBase<T extends IDbEntity> implements IRepositoryBase<T>
{
    @Override
    public int count()
    {
        return 0;
    }

    @Override
    public ArrayList<T> findAll()
    {
        return null;
    }

    @Override
    public Optional<T> findById(String id)
    {
        return Optional.empty();
    }

    @Override
    public T save(T entity)
    {
        return null;
    }

    @Override
    public ArrayList<T> saveAll(ArrayList<T> entities)
    {
        return null;
    }

    @Override
    public boolean delete(T entity)
    {
        return false;
    }

    @Override
    public boolean deleteById(String id)
    {
        return false;
    }
}
