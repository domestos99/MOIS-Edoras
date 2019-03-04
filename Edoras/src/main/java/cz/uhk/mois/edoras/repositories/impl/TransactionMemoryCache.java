package cz.uhk.mois.edoras.repositories.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.config.AppConfig;

@Service
public class TransactionMemoryCache extends InMemoryRepositoryBase<Transaction> {

    @Override
    @Scheduled(fixedRate = AppConfig.TIME_CACHE_SYNC)
    protected void syncMemoryCache() {
        List<Transaction> listFromApi = Arrays.asList(BankingApiFacade.getTransactions());
        if (listFromApi != null) {
            super.storage = listFromApi;
            System.out.println("Transaction cache sync");
        } else {
            System.out.println("Transaction cache sync failed");
        }
    }
}
