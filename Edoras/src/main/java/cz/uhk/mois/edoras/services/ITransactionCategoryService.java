package cz.uhk.mois.edoras.services;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;

public interface ITransactionCategoryService
{
    String getCategoryForPayment(Transaction transaction);
}
