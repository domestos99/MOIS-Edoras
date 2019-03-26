package cz.uhk.mois.edoras.repositories.DAO;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import cz.uhk.mois.edoras.domain.Category;
/*
 * Domčo nemůže tam být CrudRepository chápeš..
 * findAll a ostatní tam nejde.
 */
public interface CategoryDAO extends JpaRepository<Category, String>
{
}
