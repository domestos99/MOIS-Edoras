package cz.uhk.mois.edoras.services;

import java.util.ArrayList;
import java.util.Optional;

import cz.uhk.mois.edoras.domain.Category;

public interface ICategoryService
{
    ArrayList<Category> getAll();

    Optional<Category> getById(String id);

    Category insert(Category category);

    Category update(String id, Category category);

    boolean delete(String id);
}
