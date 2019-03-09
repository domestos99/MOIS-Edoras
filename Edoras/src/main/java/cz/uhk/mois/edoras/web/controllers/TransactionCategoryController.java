package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.domain.TransactionCategory;
import cz.uhk.mois.edoras.services.imp.TransactionCategoryService;
import cz.uhk.mois.edoras.web.dto.TransactionCategoryUpdateDTO;

@RestController
public class TransactionCategoryController
{
    private final TransactionCategoryService transactionCategoryService;

    @Autowired
    public TransactionCategoryController(TransactionCategoryService transactionCategoryService)
    {
        this.transactionCategoryService = transactionCategoryService;
    }

    @PutMapping("/api/transactioncategory")
    public ResponseEntity<TransactionCategory> updateCategory(@RequestBody TransactionCategoryUpdateDTO transactionCategoryUpdateDTO)
    {
        TransactionCategory cat = transactionCategoryService.update(transactionCategoryUpdateDTO);
        if (cat == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(cat, HttpStatus.CREATED);
    }
}
