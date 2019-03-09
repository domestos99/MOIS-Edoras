package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.repositories.DAO.TransactionDAO;
import cz.uhk.mois.edoras.services.ITransactionService;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryDTO;

@Service
public class TransactionService implements ITransactionService
{
    private final TransactionDAO transactionDAO;
    private final TransactionCategoryService transactionCategoryService;

    @Autowired
    public TransactionService(TransactionDAO transactionDAO, TransactionCategoryService transactionCategoryService)
    {
        this.transactionDAO = transactionDAO;
        this.transactionCategoryService = transactionCategoryService;
    }

    @Override
    public List<TransactionCategoryDTO> findAll()
    {
        List<Transaction> transactions = transactionDAO.findAll();

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
        Optional<Transaction> transaction = transactionDAO.findById(id);

        if (!transaction.isPresent())
            return Optional.empty();

        TransactionCategoryDTO dto = new TransactionCategoryDTO();
        dto.setTransaction(transaction.get());
        dto.setCategoryId(findCategoryForTransaction(transaction.get()));

        return Optional.of(dto);
    }

    private String findCategoryForTransaction(Transaction transaction)
    {
        return transactionCategoryService.getCategoryForPayment(transaction);
    }
}
