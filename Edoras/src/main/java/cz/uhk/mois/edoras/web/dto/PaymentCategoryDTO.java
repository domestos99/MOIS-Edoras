package cz.uhk.mois.edoras.web.dto;

import java.io.Serializable;

import cz.uhk.mois.edoras.bankingapi.model.Payment;

public class PaymentCategoryDTO implements Serializable
{
    private Payment payment;

    public Payment getPayment()
    {
        return payment;
    }

    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }

}
