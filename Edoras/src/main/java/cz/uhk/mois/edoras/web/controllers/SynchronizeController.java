package cz.uhk.mois.edoras.web.controllers;

import cz.uhk.mois.edoras.dao.CategoryDAO;
import cz.uhk.mois.edoras.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.uhk.mois.edoras.jobs.BankingApiSyncJob;

@RestController
public class SynchronizeController {
    private final BankingApiSyncJob bankingApiSyncJob;
    private final CategoryDAO categoryDAO;

    @Autowired
    public SynchronizeController(BankingApiSyncJob bankingApiSyncJob, CategoryDAO categoryDAO) {
        this.bankingApiSyncJob = bankingApiSyncJob;
        this.categoryDAO = categoryDAO;
    }

    @GetMapping("/api/synchronizenow")
    public ResponseEntity<Boolean> syncNow() {
        bankingApiSyncJob.syncPaymentsAndTransactions();

        Category category = new Category();

        category.setName("Income");
        category.setIcon("home");
        category.setType("INCOME");
        categoryDAO.save(category);

        category = new Category();

        category.setName("Expense");
        category.setIcon("shopping_cart");
        category.setType("EXPENSE");

        categoryDAO.save(category);

        return new ResponseEntity(true, HttpStatus.OK);
    }
}
