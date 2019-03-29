package cz.uhk.mois.edoras.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.dao.CategoryDAO;
import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.services.IOverviewService;
import cz.uhk.mois.edoras.web.dto.TransactionOverviewDTO;

@Service
public class OverviewService implements IOverviewService
{
    private final CategoryDAO categoryDAO;
    private final PaymentCategoryService paymentCategoryService;

    @Autowired
    public OverviewService(CategoryDAO categoryDAO, PaymentCategoryService paymentCategoryService)
    {
        this.categoryDAO = categoryDAO;
        this.paymentCategoryService = paymentCategoryService;
    }

    @Override
    public List<TransactionOverviewDTO> getTransactionOverview()
    {
        List<TransactionOverviewDTO> result = new ArrayList<>();

        Iterable<Category> categories = categoryDAO.findAll();

        for (Category cat : categories)
        {
            TransactionOverviewDTO dto = new TransactionOverviewDTO();
            dto.setCategory(cat);
            List<Transaction> transactionList = cat.getTransactions();
            dto.setTransactions(transactionList);
            dto.setSuma(sumPayments(transactionList));

            result.add(dto);
        }

        return result;
    }

    private BigDecimal sumPayments(List<Transaction> transactionList)
    {
        if (transactionList == null)
            return new BigDecimal(0);

        BigDecimal sum = new BigDecimal(0);
        for (Transaction p : transactionList)
        {
            if (p.getValue() != null && p.getValue().getAmount() != null)
                sum = sum.add(p.getValue().getAmount());
        }
        return sum;
    }
}
