package cz.uhk.mois.edoras.dao;

import org.springframework.data.repository.CrudRepository;

import cz.uhk.mois.edoras.domain.TransactionCategory;

public interface TransactionCategoryDAO extends CrudRepository<TransactionCategory, String>
{
    TransactionCategory findByTransactionId(String transactionId);

    TransactionCategory findByTransactionAccount(String transactionAccount);
}
