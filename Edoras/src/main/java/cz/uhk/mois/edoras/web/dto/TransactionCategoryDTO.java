package cz.uhk.mois.edoras.web.dto;

import java.io.Serializable;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;

public class TransactionCategoryDTO implements Serializable
{
    private Transaction transaction;

    public Transaction getTransaction()
    {
        return transaction;
    }

    public void setTransaction(Transaction transaction)
    {
        this.transaction = transaction;
    }
}
