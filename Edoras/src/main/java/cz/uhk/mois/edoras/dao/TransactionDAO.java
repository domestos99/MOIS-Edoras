package cz.uhk.mois.edoras.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;

public interface TransactionDAO extends JpaRepository<Transaction, String> {
}
