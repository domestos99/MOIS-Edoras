package cz.uhk.mois.edoras.services;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface ITransactionService {

    List<Transaction> findAll();

    Optional<Transaction> getById(String id);

}
