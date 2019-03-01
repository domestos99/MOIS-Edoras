package cz.uhk.mois.edoras.web.dto;

import java.io.Serializable;

import cz.uhk.mois.edoras.bankingapi.model.Payment;

public class PaymentCategoryDTO implements Serializable
{
    private Payment payment;
    private String categoryId;

    public Payment getPayment()
    {
        return payment;
    }

    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }
}
