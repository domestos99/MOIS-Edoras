package cz.uhk.mois.edoras.repositories.impl;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.List;

public class PaymentMemoryCache extends InMemoryRepositoryBase<Payment> {


    @Override
    protected void onInitData() {

        List<Payment> listFromApi = Arrays.asList(BankingApiFacade.getPayments());
        super.storage = listFromApi;
        System.out.println("Payment cache sync");

    }

    @Scheduled(fixedRate = 60000)
    public void syncMemoryCache() {
        List<Payment> listFromApi = Arrays.asList(BankingApiFacade.getPayments());
        super.storage = listFromApi;
        System.out.println("Payment cache sync");
    }

}
