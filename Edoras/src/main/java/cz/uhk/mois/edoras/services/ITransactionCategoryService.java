package cz.uhk.mois.edoras.services;

import cz.uhk.mois.edoras.bankingapi.model.Transaction;
import cz.uhk.mois.edoras.domain.TransactionCategory;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryInsertDTO;

public interface ITransactionCategoryService
{
    String getCategoryForPayment(Transaction transaction);

    TransactionCategory insert(TransactionCategoryInsertDTO paymentCategoryInsertDTO);
}
