package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.services.imp.TransactionCategoryService;

@RestController
public class TransactionCategoryController
{
    private final TransactionCategoryService transactionCategoryService;

    @Autowired
    public TransactionCategoryController(TransactionCategoryService transactionCategoryService)
    {
        this.transactionCategoryService = transactionCategoryService;
    }
}
