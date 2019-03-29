package cz.uhk.mois.edoras.services;

import cz.uhk.mois.edoras.domain.PaymentCategory;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryUpdateDTO;

public interface IPaymentCategoryService
{
    PaymentCategory update(PaymentCategoryUpdateDTO paymentCategoryUpdateDTO);
}
