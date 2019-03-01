package cz.uhk.mois.edoras.repositories.DAO;

import org.springframework.data.repository.CrudRepository;

import cz.uhk.mois.edoras.domain.PaymentCategory;

public interface PaymentCategoryDAO extends CrudRepository<PaymentCategory, String>
{
    PaymentCategory findByPaymentId(String paymentId);

    PaymentCategory findByPaymentAccount(String paymentAccount);
}
