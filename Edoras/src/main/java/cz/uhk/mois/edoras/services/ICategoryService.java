package cz.uhk.mois.edoras.services;

import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.domain.Category;

public interface ICategoryService
{
    List<Category> getAll();

    Optional<Category> getById(String id);

    Category insert(Category category);

    Category update(Category category);

    boolean delete(String id);
}
