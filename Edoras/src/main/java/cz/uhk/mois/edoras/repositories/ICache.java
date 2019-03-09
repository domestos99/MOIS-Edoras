package cz.uhk.mois.edoras.repositories;

import java.util.List;

public interface ICache<T> {

    void syncMemoryCache();

    void refreshAll();

    void syncMemoryCache(List<T> entities);

}
