package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.repositories.ICategoryRepository;
import cz.uhk.mois.edoras.services.ICategoryService;

@Service
public class CategoryService implements ICategoryService
{
    private final ICategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ArrayList<Category> getAll()
    {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getById(String id)
    {
        return categoryRepository.findById(id);
    }

    @Override
    public Category insert(Category category)
    {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(String id, Category category)
    {
        category.setCateID(id);
        return categoryRepository.save(category);
    }

    @Override
    public boolean delete(String id)
    {
        return categoryRepository.deleteById(id);
    }
}
