package cz.uhk.mois.edoras.web.controllers;

import cz.uhk.mois.edoras.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {

    private ITransactionService transactionService;

    @Autowired
    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/api/transactions")
    public ResponseEntity<List<Transaction>> getAll() {
        List<Transaction> transactions = transactionService.findAll();
        return new ResponseEntity(transactions, HttpStatus.OK);
    }

    @GetMapping("/api/transaction/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") String id) {

        Optional<Transaction> transaction = null;

        if (!transaction.isPresent()) {
            return new ResponseEntity(transaction.get(), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
