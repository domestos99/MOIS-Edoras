package cz.uhk.mois.edoras.services.imp;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.repositories.impl.PaymentMemoryCache;
import cz.uhk.mois.edoras.services.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentMemoryCache memoryCache;

    @Override
    public List<Payment> findAll() {

        List<Payment> payments = Arrays.asList(BankingApiFacade.getPayments());

        if(payments == null){
            payments = memoryCache.findAll();
        }

        return payments;
    }

    @Override
    public Optional<Payment> getById(String id) {

        Optional<Payment> payment = Optional.of(BankingApiFacade.getPaymentById(id));

        if(payment == null){
            payment = memoryCache.findById(id);
        }

        return payment;
    }
}
