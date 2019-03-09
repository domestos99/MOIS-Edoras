package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.jobs.BankingApiSyncJob;

@RestController
public class SynchronizeController
{
    private final BankingApiSyncJob bankingApiSyncJob;

    @Autowired
    public SynchronizeController(BankingApiSyncJob bankingApiSyncJob)
    {
        this.bankingApiSyncJob = bankingApiSyncJob;
    }

    @GetMapping("/api/synchronizenow")
    public ResponseEntity<Boolean> syncNow()
    {
        bankingApiSyncJob.syncPaymentsAndTransactions();
        return new ResponseEntity(true, HttpStatus.OK);
    }
}
