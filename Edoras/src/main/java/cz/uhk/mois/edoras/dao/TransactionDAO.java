package cz.uhk.mois.edoras.dao;

import cz.uhk.mois.edoras.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionDAO extends JpaRepository<Transaction, String> {

    List<Transaction> findByValueDateBetweenOrderByValueDateDesc(Date from, Date to);

    List<Transaction> findByCategoryOrderByValueDateDesc(Category category);

    List<Transaction> findByValueDateBetweenAndCategoryOrderByValueDateDesc(Date from, Date to, Category category);
}
