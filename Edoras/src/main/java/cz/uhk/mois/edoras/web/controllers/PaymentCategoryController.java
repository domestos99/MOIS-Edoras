package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.domain.PaymentCategory;
import cz.uhk.mois.edoras.web.dto.PaymentCategoryUpdateDTO;

@RestController
public class PaymentCategoryController
{
 //   private final PaymentCategoryService paymentCategoryService;

   /* @Autowired
    public PaymentCategoryController(PaymentCategoryService paymentCategoryService)
    {
        //this.paymentCategoryService = paymentCategoryService;
    }
*/
    @PutMapping("/api/paymentcategory")
    public ResponseEntity<PaymentCategory> updateCategory(@RequestBody PaymentCategoryUpdateDTO paymentCategoryUpdateDTO)
    {/*
        //PaymentCategory cat = paymentCategoryService.update(paymentCategoryUpdateDTO);
        if (cat == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(cat, HttpStatus.CREATED);*/
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

}
