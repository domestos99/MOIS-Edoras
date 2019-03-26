package cz.uhk.mois.edoras.domain;


import java.io.Serializable;


public class PaymentCategory implements Serializable
{
    private String id;

    private String categoryId;
    private String paymentId;
    private String paymentAccount;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getPaymentId()
    {
        return paymentId;
    }

    public void setPaymentId(String paymentId)
    {
        this.paymentId = paymentId;
    }

    public String getPaymentAccount()
    {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount)
    {
        this.paymentAccount = paymentAccount;
    }
}