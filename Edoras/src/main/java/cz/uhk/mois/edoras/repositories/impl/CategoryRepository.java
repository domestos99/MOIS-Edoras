package cz.uhk.mois.edoras.repositories.impl;

import org.springframework.stereotype.Repository;

import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.repositories.ICategoryRepository;


@Repository
public class CategoryRepository extends InMemoryRepositoryBase<Category> implements ICategoryRepository
{

    @Override
    protected void onInitData()
    {
        Category c1 = new Category("1", "Food");
        Category c2 = new Category("2", "Restaurant");

        super.save(c1);
        super.save(c2);
    }
}
