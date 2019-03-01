package cz.uhk.mois.edoras.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.domain.IDbEntity;
import cz.uhk.mois.edoras.repositories.IRepositoryBase;

public abstract class InMemoryRepositoryBase<T extends IDbEntity> implements IRepositoryBase<T>
{
    protected List<T> storage;

    public InMemoryRepositoryBase()
    {
        this.storage = new ArrayList<>();
        syncMemoryCache();
    }

    protected abstract void syncMemoryCache();

    @Override
    public int count()
    {
        return storage.size();
    }

    @Override
    public List<T> findAll()
    {
        return storage;
    }

    @Override
    public Optional<T> findById(String id)
    {
        for (T en : storage)
        {
            if (en.getId().equals(id))
                return Optional.of(en);
        }
        return Optional.empty();
    }

    @Override
    public T save(T entity)
    {
        return null;
    }

    @Override
    public List<T> saveAll(List<T> entities)
    {
        return null;
    }

    @Override
    public boolean delete(T entity)
    {
        return storage.remove(entity);
    }

    @Override
    public boolean deleteById(String id)
    {
        Optional<T> en = findById(id);
        if (en.isPresent())
            return storage.remove(en);
        return false;
    }
}
