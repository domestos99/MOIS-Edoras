package cz.uhk.mois.edoras.services.imp;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.repositories.impl.TransactionMemoryCache;
import cz.uhk.mois.edoras.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionMemoryCache memoryCache;

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = Arrays.asList(BankingApiFacade.getTransactions());

        if (transactions == null) {
            transactions = memoryCache.findAll();
        }

        return transactions;
    }

    @Override
    public Optional<Transaction> getById(String id) {

        Optional<Transaction> transaction = Optional.of(BankingApiFacade.getTransactionById(id));

        if(transaction == null){
            transaction = memoryCache.findById(id);
        }

        return transaction;
    }
}
