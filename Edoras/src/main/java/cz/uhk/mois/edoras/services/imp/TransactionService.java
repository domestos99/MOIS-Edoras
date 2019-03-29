package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.dao.TransactionDAO;
import cz.uhk.mois.edoras.services.ITransactionService;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryDTO;

@Service
public class TransactionService implements ITransactionService
{
    private final TransactionDAO transactionDAO;

    @Autowired
    public TransactionService(TransactionDAO transactionDAO)
    {
        this.transactionDAO = transactionDAO;
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

        return Optional.of(dto);
    }

}
