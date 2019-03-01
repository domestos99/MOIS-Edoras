package cz.uhk.mois.edoras.web.controllers;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.utils.ListUtils;
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

@RestController
public class TransactionController
{

    private final ITransactionService transactionService;

    @Autowired
    public TransactionController(ITransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    @GetMapping("/api/transactions")
    public ResponseEntity<List<Transaction>> getAll()
    {
        List<TransactionCategoryDTO> transactions = transactionService.findAll();
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
