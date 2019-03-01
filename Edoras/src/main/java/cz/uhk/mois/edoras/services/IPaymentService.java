package cz.uhk.mois.edoras.services;

import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.web.dto.PaymentCategoryDTO;

public interface IPaymentService {

    List<PaymentCategoryDTO> findAll();

    Optional<PaymentCategoryDTO> getById(String id);

}
