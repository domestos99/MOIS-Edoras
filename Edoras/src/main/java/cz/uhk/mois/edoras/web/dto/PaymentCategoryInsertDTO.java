package cz.uhk.mois.edoras.web.dto;

import java.io.Serializable;

import cz.uhk.mois.edoras.bankingapi.model.TransactionPartyAccount;

public class PaymentCategoryInsertDTO implements Serializable
{
    private String categoryId;
    private String paymentId;
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

    public String getPaymentId()
    {
        return paymentId;
    }

    public void setPaymentId(String paymentId)
    {
        this.paymentId = paymentId;
    }
}
