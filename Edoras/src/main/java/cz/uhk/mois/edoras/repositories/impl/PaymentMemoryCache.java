package cz.uhk.mois.edoras.repositories.impl;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;
import cz.uhk.mois.edoras.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class PaymentMemoryCache extends InMemoryRepositoryBase<Payment> {


    @Override
    protected void onInitData() {
        List<Payment> listFromApi = Arrays.asList(BankingApiFacade.getPayments());
        super.storage = listFromApi;
    }
}
