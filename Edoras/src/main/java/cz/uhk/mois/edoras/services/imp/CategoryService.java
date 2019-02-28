package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.repositories.DAO.CategoryDAO;
import cz.uhk.mois.edoras.services.ICategoryService;
import cz.uhk.mois.edoras.utils.ListUtils;
import cz.uhk.mois.edoras.utils.StringUtil;

@Service
public class CategoryService implements ICategoryService
{
    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryService(CategoryDAO categoryDAO)
    {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public ArrayList<Category> getAll()
    {
        return ListUtils.toList(categoryDAO.findAll());
    }

    @Override
    public Optional<Category> getById(String id)
    {
        return categoryDAO.findById(id);
    }

    @Override
    public Category insert(Category category)
    {
        return categoryDAO.save(category);
    }

    @Override
    public Category update(Category category)
    {
        return categoryDAO.save(category);
    }

    @Override
    public boolean delete(String id)
    {
        if (StringUtil.isEmptyOrNull(id))
            return false;

        if (categoryDAO.existsById(id))
        {
            categoryDAO.deleteById(id);
            return true;
        }
        return false;
    }
}
