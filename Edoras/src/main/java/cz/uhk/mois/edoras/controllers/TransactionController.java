package cz.uhk.mois.edoras.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.api.BankingApiFacade;
import cz.uhk.mois.edoras.api.model.Transaction;

@RestController
public class TransactionController
{
    @GetMapping("/transactions")
    public ResponseEntity<Transaction[]> getAll()
    {
        Transaction[] transactions = BankingApiFacade.getTransactions();
        return new ResponseEntity(transactions, HttpStatus.OK);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") String id)
    {
        // TODO
        Transaction payments = BankingApiFacade.getTransactionById(id);
        if (payments == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(payments, HttpStatus.OK);
    }
}
