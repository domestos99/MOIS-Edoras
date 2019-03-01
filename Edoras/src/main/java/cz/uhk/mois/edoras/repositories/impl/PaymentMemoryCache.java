package cz.uhk.mois.edoras.repositories.impl;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.config.AppConfig;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.List;

public class PaymentMemoryCache extends InMemoryRepositoryBase<Payment> {


    @Scheduled(fixedRate = AppConfig.TIME_CACHE_SYNC)
    public void syncMemoryCache() {
        List<Payment> listFromApi = Arrays.asList(BankingApiFacade.getPayments());
        if (listFromApi != null) {
            super.storage = listFromApi;
            System.out.println("Payment cache sync");
        } else {
            System.out.println("Payment cache sync failed");
        }
    }

}
