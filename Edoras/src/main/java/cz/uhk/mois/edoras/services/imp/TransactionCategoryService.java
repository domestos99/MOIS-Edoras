package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.domain.TransactionCategory;
import cz.uhk.mois.edoras.helpers.imp.AccountHelper;
import cz.uhk.mois.edoras.repositories.DAO.TransactionCategoryDAO;
import cz.uhk.mois.edoras.services.ITransactionCategoryService;
import cz.uhk.mois.edoras.web.dto.ChangeType;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryUpdateDTO;

@Service
public class TransactionCategoryService implements ITransactionCategoryService
{
    private final TransactionCategoryDAO transactionCategoryDAO;

    @Autowired
    public TransactionCategoryService(TransactionCategoryDAO transactionCategoryDAO)
    {
        this.transactionCategoryDAO = transactionCategoryDAO;
    }

    @Override
    public String getCategoryForPayment(final Transaction transaction)
    {
        String id = transaction.getId();

        TransactionCategory category = transactionCategoryDAO.findByTransactionId(id);

        if (category == null)
        {
            String account = AccountHelper.getAccountId(transaction.getPartyAccount());
            category = transactionCategoryDAO.findByTransactionAccount(account);
        }
        if (category == null)
            return null;

        return category.getCategoryId();
    }


    @Override
    public TransactionCategory update(TransactionCategoryUpdateDTO transactionCategoryUpdateDTO)
    {
        TransactionCategory paymentCategory = new TransactionCategory();

        if (transactionCategoryUpdateDTO == null)
        {
            return null;
        }

        paymentCategory.setCategoryId(transactionCategoryUpdateDTO.getCategoryId());

        if (transactionCategoryUpdateDTO.getChangeType() == ChangeType.ONE)
        {
            paymentCategory.setTransactionId(transactionCategoryUpdateDTO.getTransactionId());
        }
        else
        {
            // for ALL
            paymentCategory.setTransactionAccount(AccountHelper.getAccountId(transactionCategoryUpdateDTO.getTransactionPartyAccount()));

            // Load ID if exists
            // Try find by paymentID
            TransactionCategory pc = transactionCategoryDAO.findByTransactionId(transactionCategoryUpdateDTO.getTransactionId());
            if (pc != null)
            {
                transactionCategoryDAO.delete(pc);
                pc = null;
            }
            if (pc == null)
            {
                // Try find by account
                pc = transactionCategoryDAO.findByTransactionAccount(AccountHelper.getAccountId(transactionCategoryUpdateDTO.getTransactionPartyAccount()));
            }

            if (pc != null)
            {
                paymentCategory.setId(pc.getId());
            }
        }


        return transactionCategoryDAO.save(paymentCategory);
    }
}
