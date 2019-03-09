package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.repositories.impl.TransactionMemoryCache;
import cz.uhk.mois.edoras.services.ITransactionService;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryDTO;

@Service
public class TransactionService implements ITransactionService
{
    private final TransactionMemoryCache memoryCache;
    private final TransactionCategoryService transactionCategoryService;

    @Autowired
    public TransactionService(TransactionMemoryCache memoryCache, TransactionCategoryService transactionCategoryService)
    {
        this.memoryCache = memoryCache;
        this.transactionCategoryService = transactionCategoryService;
    }

    @Override
    public List<TransactionCategoryDTO> findAll()
    {
        List<Transaction> transactions = memoryCache.findAll();

        if (transactions == null)
        {
            transactions = Arrays.asList(BankingApiFacade.getTransactions());
        }

        List<TransactionCategoryDTO> result = new ArrayList<>();

        for (Transaction p : transactions)
        {
            TransactionCategoryDTO dto = new TransactionCategoryDTO();
            dto.setTransaction(p);
            dto.setCategoryId(findCategoryForTransaction(p));
            result.add(dto);
        }
        return result;
    }

    @Override
    public Optional<TransactionCategoryDTO> getById(String id)
    {
        Transaction transaction = memoryCache.findById(id);

        if (transaction == null)
        {
            transaction = BankingApiFacade.getTransactionById(id);
        }
        if (transaction == null) // Not Found at all
            return Optional.empty();

        TransactionCategoryDTO dto = new TransactionCategoryDTO();
        dto.setTransaction(transaction);
        dto.setCategoryId(findCategoryForTransaction(transaction));

        return Optional.of(dto);
    }

    private String findCategoryForTransaction(Transaction transaction)
    {
        return transactionCategoryService.getCategoryForPayment(transaction);
    }
}
