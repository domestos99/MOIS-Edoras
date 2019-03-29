package cz.uhk.mois.edoras.services;

import cz.uhk.mois.edoras.domain.TransactionCategory;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryUpdateDTO;

public interface ITransactionCategoryService
{
    TransactionCategory update(TransactionCategoryUpdateDTO transactionCategoryUpdateDTO);
}
