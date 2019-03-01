package cz.uhk.mois.edoras.services;

import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.web.dto.TransactionCategoryDTO;

public interface ITransactionService
{

    List<TransactionCategoryDTO> findAll();

    Optional<TransactionCategoryDTO> getById(String id);

}
