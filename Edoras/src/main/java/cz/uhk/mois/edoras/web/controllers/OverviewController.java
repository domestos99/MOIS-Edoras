package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import cz.uhk.mois.edoras.services.IOverviewService;
import cz.uhk.mois.edoras.web.dto.TransactionOverviewDTO;

@RestController
public class OverviewController
{
    private final IOverviewService overviewService;

    @Autowired
    public OverviewController(IOverviewService overviewService)
    {
        this.overviewService = overviewService;
    }

    @GetMapping("/api/overview/transaction")
    public ResponseEntity<List<TransactionOverviewDTO>> getPaymentOverview()
    {
        List<TransactionOverviewDTO> payments = overviewService.getTransactionOverview();
        return new ResponseEntity(payments, HttpStatus.OK);
    }
}
