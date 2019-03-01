package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.domain.TransactionCategory;
import cz.uhk.mois.edoras.services.imp.TransactionCategoryService;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryInsertDTO;

@RestController
public class TransactionCategoryController
{
    private final TransactionCategoryService transactionCategoryService;

    @Autowired
    public TransactionCategoryController(TransactionCategoryService transactionCategoryService)
    {
        this.transactionCategoryService = transactionCategoryService;
    }

    @PostMapping("/api/transactioncategory")
    public ResponseEntity<TransactionCategory> insertCategory(@RequestBody TransactionCategoryInsertDTO paymentCategoryInsertDTO)
    {
        TransactionCategory cat = transactionCategoryService.insert(paymentCategoryInsertDTO);
        if (cat == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(cat, HttpStatus.CREATED);
    }
}
