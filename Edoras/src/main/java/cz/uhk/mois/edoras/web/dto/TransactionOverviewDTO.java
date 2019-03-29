package cz.uhk.mois.edoras.web.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.domain.Category;

public class TransactionOverviewDTO implements Serializable
{
    private Category category;
    private List<Transaction> transactions;
    private BigDecimal suma;

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public List<Transaction> getTransactions()
    {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions)
    {
        this.transactions = transactions;
    }

    public BigDecimal getSuma()
    {
        return suma;
    }

    public void setSuma(BigDecimal suma)
    {
        this.suma = suma;
    }
}
