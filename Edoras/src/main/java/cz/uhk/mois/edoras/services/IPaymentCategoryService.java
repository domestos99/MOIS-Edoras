package cz.uhk.mois.edoras.services;

import cz.uhk.mois.edoras.bankingapi.model.Payment;

public interface IPaymentCategoryService
{
    String getCategoryForPayment(Payment payment);

}
