package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.domain.PaymentCategory;
import cz.uhk.mois.edoras.services.imp.PaymentCategoryService;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryInsertDTO;

@RestController
public class PaymentCategoryController
{
    private final PaymentCategoryService paymentCategoryService;

    @Autowired
    public PaymentCategoryController(PaymentCategoryService paymentCategoryService)
    {
        this.paymentCategoryService = paymentCategoryService;
    }


    @PostMapping("/api/paymentcategory")
    public ResponseEntity<PaymentCategory> insertCategory(@RequestBody PaymentCategoryInsertDTO paymentCategoryInsertDTO)
    {
        PaymentCategory cat = paymentCategoryService.insert(paymentCategoryInsertDTO);
        if (cat == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(cat, HttpStatus.CREATED);
    }

}
