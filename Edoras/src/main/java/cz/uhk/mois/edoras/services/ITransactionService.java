package cz.uhk.mois.edoras.services;

import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.web.dto.TransactionCategoryDTO;
import cz.uhk.mois.edoras.web.dto.TransactionFilterModel;

public interface ITransactionService
{

    List<TransactionCategoryDTO> findAll(TransactionFilterModel filterModel);

    Optional<TransactionCategoryDTO> getById(String id);

}
