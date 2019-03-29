package cz.uhk.mois.edoras.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.mois.edoras.domain.Category;

public interface CategoryDAO extends JpaRepository<Category, String>
{
}
