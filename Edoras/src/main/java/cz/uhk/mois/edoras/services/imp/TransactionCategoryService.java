package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.domain.TransactionCategory;
import cz.uhk.mois.edoras.helpers.imp.AccountHelper;
import cz.uhk.mois.edoras.repositories.DAO.TransactionCategoryDAO;
import cz.uhk.mois.edoras.services.ITransactionCategoryService;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryInsertDTO;

@Service
public class TransactionCategoryService implements ITransactionCategoryService {
    private final TransactionCategoryDAO transactionCategoryDAO;

    @Autowired
    public TransactionCategoryService(TransactionCategoryDAO transactionCategoryDAO) {
        this.transactionCategoryDAO = transactionCategoryDAO;
    }

    @Override
    public String getCategoryForPayment(final Transaction transaction) {
        String id = transaction.getId();

        TransactionCategory category = transactionCategoryDAO.findByTransactionId(id);

        if (category == null) {
            String account = AccountHelper.getAccountId(transaction.getPartyAccount());
            category = transactionCategoryDAO.findByTransactionAccount(account);
        }
        if (category == null)
            return null;

        return category.getCategoryId();
    }

    @Override
    public TransactionCategory insert(TransactionCategoryInsertDTO transactionCategoryInsertDTO) {
        TransactionCategory transactionCategory = new TransactionCategory();

        if (transactionCategoryInsertDTO == null) {
            return null;
        }
        transactionCategory.setCategoryId(transactionCategoryInsertDTO.getCategoryId());
        transactionCategory.setCategoryId(transactionCategoryInsertDTO.getCategoryId());
        transactionCategory.setTransactionAccount(AccountHelper.getAccountId(transactionCategoryInsertDTO.getTransactionPartyAccount()));
        return transactionCategoryDAO.save(transactionCategory);
    }
}
