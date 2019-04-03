package cz.uhk.mois.edoras.services;

import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.web.dto.PaymentCategoryDTO;
import cz.uhk.mois.edoras.web.dto.PaymentFilterModel;

public interface IPaymentService {

    List<PaymentCategoryDTO> findAll(final PaymentFilterModel filterModel);

    Optional<PaymentCategoryDTO> getById(String id);

}
