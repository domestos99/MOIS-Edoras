package cz.uhk.mois.edoras.repositories.DAO;

import org.springframework.data.repository.CrudRepository;

import cz.uhk.mois.edoras.domain.Category;

public interface CategoryDAO extends CrudRepository<Category, String>
{
}
