package cz.uhk.mois.edoras.dao;

import cz.uhk.mois.edoras.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import java.util.Date;
import java.util.List;

public interface PaymentDAO extends JpaRepository<Payment, String>
{

    List<Payment> findByDueDateBetweenOrderByCategoryDesc(Date from, Date to);

    List<Payment> findByCategory(Category category);

    List<Payment> findByDueDateBetweenAndCategoryOrderByCategoryDesc(Date from, Date to, Category category);
}
