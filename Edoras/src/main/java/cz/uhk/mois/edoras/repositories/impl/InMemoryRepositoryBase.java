package cz.uhk.mois.edoras.repositories.impl;

import java.util.ArrayList;
import java.util.Optional;

import cz.uhk.mois.edoras.domain.IDbEntity;
import cz.uhk.mois.edoras.repositories.IRepositoryBase;

public abstract class InMemoryRepositoryBase<T extends IDbEntity> implements IRepositoryBase<T>
{
    private final ArrayList<T> storage;

    public InMemoryRepositoryBase()
    {
        this.storage = new ArrayList<>();
        onInitData();
    }

    protected abstract void onInitData();

    @Override
    public int count()
    {
        return storage.size();
    }

    @Override
    public ArrayList<T> findAll()
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
    public ArrayList<T> saveAll(ArrayList<T> entities)
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
