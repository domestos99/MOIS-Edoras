package cz.uhk.mois.edoras.web.controllers;

import cz.uhk.mois.edoras.repositories.impl.PaymentMemoryCache;
import cz.uhk.mois.edoras.services.IPaymentService;
import cz.uhk.mois.edoras.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.bankingapi.BankingApiFacade;
import cz.uhk.mois.edoras.bankingapi.model.Payment;

import java.util.List;
import java.util.Optional;

@RestController
public class PaymentController {

    private IPaymentService paymentService;

    @Autowired
    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/api/payments")
    public ResponseEntity<List<Payment>> getAll() {
        List<Payment> payments = paymentService.findAll();
        return new ResponseEntity(payments, HttpStatus.OK);
    }

    @GetMapping("/api/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") String id) {

        Optional<Payment> payments = null;

        if (!payments.isPresent()) {
            return new ResponseEntity(payments.get(), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
