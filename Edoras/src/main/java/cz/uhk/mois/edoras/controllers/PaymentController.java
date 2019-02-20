package cz.uhk.mois.edoras.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.api.BankingApiFacade;
import cz.uhk.mois.edoras.api.model.Payment;

@RestController
public class PaymentController
{
    @GetMapping("/payments")
    public ResponseEntity<Payment[]> getAll()
    {
        Payment[] payments = BankingApiFacade.getPayments();
        return new ResponseEntity(payments, HttpStatus.OK);
    }
}
