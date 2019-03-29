package cz.uhk.mois.edoras.services;

import java.util.List;

import cz.uhk.mois.edoras.web.dto.TransactionOverviewDTO;

public interface IOverviewService
{
    List<TransactionOverviewDTO> getTransactionOverview();
}
