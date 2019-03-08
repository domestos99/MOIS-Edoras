package cz.uhk.mois.edoras.repositories.DAO;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDAO extends JpaRepository<Payment, String> {
}
