package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import cz.uhk.mois.edoras.services.IPaymentService;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryDTO;

@RestController
public class PaymentController
{

    private final IPaymentService paymentService;

    @Autowired
    public PaymentController(IPaymentService paymentService)
    {
        this.paymentService = paymentService;
    }

    @GetMapping("/api/payments")
    public ResponseEntity<List<PaymentCategoryDTO>> getAll()
    {
        List<PaymentCategoryDTO> payments = paymentService.findAll();
        return new ResponseEntity(payments, HttpStatus.OK);
    }

    @GetMapping("/api/payment/{id}")
    public ResponseEntity<PaymentCategoryDTO> getPaymentById(@PathVariable("id") String id)
    {
        Optional<PaymentCategoryDTO> payments = paymentService.getById(id);

        if (payments.isPresent())
        {
            return new ResponseEntity(payments.get(), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
