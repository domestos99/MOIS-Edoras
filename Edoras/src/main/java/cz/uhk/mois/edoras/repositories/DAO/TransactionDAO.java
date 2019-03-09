package cz.uhk.mois.edoras.repositories.DAO;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDAO extends JpaRepository<Transaction, String> {
}
