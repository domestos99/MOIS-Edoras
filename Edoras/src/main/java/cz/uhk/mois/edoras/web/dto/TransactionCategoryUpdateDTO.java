package cz.uhk.mois.edoras.web.dto;

import java.io.Serializable;

import cz.uhk.mois.edoras.bankingapi.model.TransactionPartyAccount;

public class TransactionCategoryUpdateDTO implements Serializable
{
    private String id;
    private String categoryId;
    private String transactionId;
    private TransactionPartyAccount transactionPartyAccount;

    public String getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public TransactionPartyAccount getTransactionPartyAccount()
    {
        return transactionPartyAccount;
    }

    public void setTransactionPartyAccount(TransactionPartyAccount transactionPartyAccount)
    {
        this.transactionPartyAccount = transactionPartyAccount;
    }

    public String getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
