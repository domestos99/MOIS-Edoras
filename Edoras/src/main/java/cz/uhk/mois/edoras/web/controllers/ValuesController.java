package cz.uhk.mois.edoras.web.controllers;

import cz.uhk.mois.edoras.repositories.impl.PaymentCache;
import cz.uhk.mois.edoras.repositories.impl.TransactionCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class ValuesController
{

    // For testing
    @Autowired
    private PaymentCache paymentCache;

    @Autowired
    private TransactionCache transactionCache;

    @GetMapping("/api/values")
    public ResponseEntity<ArrayList<String>> getValues()
    {
        ArrayList<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        return new ResponseEntity(values, HttpStatus.OK);
    }

    //testing
    @GetMapping("/api/refresh")
    public ResponseEntity<ArrayList<String>> getRefreshCache()
    {
        paymentCache.refreshAll();
        transactionCache.refreshAll();
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}
