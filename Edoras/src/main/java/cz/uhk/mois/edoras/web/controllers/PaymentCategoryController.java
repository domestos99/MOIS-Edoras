package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.services.imp.PaymentCategoryService;

@RestController
public class PaymentCategoryController
{
    private final PaymentCategoryService paymentCategoryService;

    @Autowired
    public PaymentCategoryController(PaymentCategoryService paymentCategoryService)
    {
        this.paymentCategoryService = paymentCategoryService;
    }


}
