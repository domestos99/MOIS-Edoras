package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.services.ITransactionService;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryDTO;
import cz.uhk.mois.edoras.web.dto.TransactionFilterModel;

@RestController
public class TransactionController
{

    private final ITransactionService transactionService;

    @Autowired
    public TransactionController(ITransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    // localhost:4500/api/transactions?dtFrom=03-04-2018&dtTo=04-04-2018&cateId=test

    @GetMapping("/api/transactions")
    public ResponseEntity<List<TransactionCategoryDTO>> getAll(TransactionFilterModel filterModel)
    {
        List<TransactionCategoryDTO> transactions = transactionService.findAll(filterModel);
        return new ResponseEntity(transactions, HttpStatus.OK);
    }

    @GetMapping("/api/transaction/{id}")
    public ResponseEntity<TransactionCategoryDTO> getTransactionById(@PathVariable("id") String id)
    {
        Optional<TransactionCategoryDTO> transaction = transactionService.getById(id);

        if (transaction.isPresent())
        {
            return new ResponseEntity(transaction.get(), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
