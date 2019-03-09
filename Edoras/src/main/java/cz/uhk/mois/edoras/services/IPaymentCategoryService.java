package cz.uhk.mois.edoras.services;

import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.domain.PaymentCategory;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryUpdateDTO;

public interface IPaymentCategoryService
{
    String getCategoryForPayment(Payment payment);

    PaymentCategory update(PaymentCategoryUpdateDTO paymentCategoryUpdateDTO);
}
