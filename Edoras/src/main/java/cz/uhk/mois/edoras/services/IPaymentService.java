package cz.uhk.mois.edoras.services;

import cz.uhk.mois.edoras.bankingapi.model.Payment;

import java.util.List;
import java.util.Optional;

public interface IPaymentService {

    List<Payment> findAll();

    Optional<Payment> getById(String id);

}
