package cz.uhk.mois.edoras.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public T findById(String id)
    {
        for (T en : storage)
        {
            if (en.getId().equals(id))
                return en;
        }
        return null;
    }

    @Override
    public T save(T entity)
    {
        T opt = findById(entity.getId());

        if (opt == null)
        {
            entity.setId(UUID.randomUUID().toString());
            this.storage.add(entity);
            return entity;
        }
        else
        {
            this.storage.remove(opt);
            this.storage.add(opt);
            return opt;
        }
    }

    @Override
    public List<T> saveAll(List<T> entities)
    {
        for (T ent : entities)
        {
            save(ent);
        }
        return entities;
    }

    @Override
    public boolean delete(T entity)
    {
        return storage.remove(entity);
    }

    @Override
    public boolean deleteById(String id)
    {
        T en = findById(id);
        if (en == null)
            return false;
        return storage.remove(en);
    }
}
