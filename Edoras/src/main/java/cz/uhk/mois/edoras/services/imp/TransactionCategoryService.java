package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.constants.Constants;
import cz.uhk.mois.edoras.dao.CategoryDAO;
import cz.uhk.mois.edoras.dao.TransactionCategoryDAO;
import cz.uhk.mois.edoras.dao.TransactionDAO;
import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.domain.TransactionCategory;
import cz.uhk.mois.edoras.helpers.AccountHelper;
import cz.uhk.mois.edoras.services.ITransactionCategoryService;
import cz.uhk.mois.edoras.web.dto.ChangeType;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryUpdateDTO;

@Service
public class TransactionCategoryService implements ITransactionCategoryService
{
    private final TransactionCategoryDAO transactionCategoryDAO;
    private final TransactionDAO transactionDAO;
    private final CategoryDAO categoryDAO;

    @Autowired
    public TransactionCategoryService(TransactionCategoryDAO transactionCategoryDAO, TransactionDAO transactionDAO, CategoryDAO categoryDAO)
    {
        this.transactionCategoryDAO = transactionCategoryDAO;
        this.transactionDAO = transactionDAO;
        this.categoryDAO = categoryDAO;
    }

    @Override
    public TransactionCategory update(TransactionCategoryUpdateDTO transactionCategoryUpdateDTO)
    {
        final TransactionCategory transactionCategory = new TransactionCategory();

        if (transactionCategoryUpdateDTO == null)
        {
            return null;
        }

        Optional<Category> c = categoryDAO.findById(transactionCategoryUpdateDTO.getCategoryId());
        transactionCategory.setCategory(c.orElse(null));
        Transaction.DirectionEnum direction = Constants.INCOME.equals(c.get().getType()) ? Transaction.DirectionEnum.INCOMING : Transaction.DirectionEnum.OUTGOING;
        transactionCategory.setDirection(direction);

        if (transactionCategoryUpdateDTO.getChangeType() == ChangeType.ONE)
        {
            transactionCategory.setTransactionId(transactionCategoryUpdateDTO.getTransactionId());

            TransactionCategory pc = transactionCategoryDAO.findByTransactionId(transactionCategoryUpdateDTO.getTransactionId());
            if (pc != null)
            {
                transactionCategory.setId(pc.getId());
            }
        }
        else if (transactionCategoryUpdateDTO.getChangeType() == ChangeType.ALL)
        {
            // for ALL
            transactionCategory.setTransactionAccount(AccountHelper.getAccountId(transactionCategoryUpdateDTO.getTransactionPartyAccount()));

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
                pc = transactionCategoryDAO.findByTransactionAccountAndDirection(AccountHelper.getAccountId(transactionCategoryUpdateDTO.getTransactionPartyAccount()),
                        direction);
            }

            if (pc != null)
            {
                boolean typeOk = checkCateTransType(c.orElse(null), pc.getCategory());

                if (typeOk)
                    transactionCategory.setId(pc.getId());
            }
        }
        else
        {
            throw new RuntimeException("Invalid ChangeType");
        }

        TransactionCategory pc = transactionCategoryDAO.save(transactionCategory);
        updateTransactionCategory(transactionDAO.findAll());
        return pc;
    }

    private boolean checkCateTransType(Category c1, Category c2)
    {
        if (c1 == null || c2 == null)
            return false;

        return c1.getType().equals(c2.getType());
    }

    public List<Transaction> updateTransactionCategory(List<Transaction> transactionList)
    {
        for (Transaction p : transactionList)
        {
            p.setCategory(getCategoryForTransaction(p));
        }
        transactionDAO.saveAll(transactionList);
        return transactionList;
    }

    public Category getCategoryForTransaction(final Transaction transaction)
    {
        String id = transaction.getId();

        TransactionCategory category = transactionCategoryDAO.findByTransactionId(id);

        if (category == null)
        {
            String account = AccountHelper.getAccountId(transaction.getPartyAccount());
            category = transactionCategoryDAO.findByTransactionAccountAndDirection(account, transaction.getDirection());
        }
        if (category == null)
            return null;

        Category cat = category.getCategory();

        if (cat == null)
            return null;

        if (transaction.getDirection() == Transaction.DirectionEnum.INCOMING && !Constants.INCOME.equals(cat.getType()))
            return null;
        if (transaction.getDirection() == Transaction.DirectionEnum.OUTGOING && !Constants.EXPENSE.equals(cat.getType()))
            return null;

        return cat;
    }

    private Category getCategoryById(String cateId)
    {
        Optional<Category> cateOpt = categoryDAO.findById(cateId);
        return cateOpt.orElse(null);
    }

}
