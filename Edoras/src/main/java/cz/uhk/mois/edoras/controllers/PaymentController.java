package cz.uhk.mois.edoras.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;

@RestController
public class PaymentController
{
    @GetMapping("/payments")
    public ResponseEntity<Payment[]> getAll()
    {
        Payment[] payments = BankingApiFacade.getPayments();
        return new ResponseEntity(payments, HttpStatus.OK);
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") String id)
    {
        // TODO
        Payment payments = BankingApiFacade.getPaymentById(id);
        if (payments == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(payments, HttpStatus.OK);
    }
}
