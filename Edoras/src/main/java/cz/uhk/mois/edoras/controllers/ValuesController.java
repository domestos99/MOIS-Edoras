package cz.uhk.mois.edoras.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ValuesController
{
    @Autowired
    public ValuesController()
    {

    }

    @GetMapping("/values")
    public ResponseEntity<ArrayList<String>> getClients()
    {
        ArrayList<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        return new ResponseEntity(values, HttpStatus.OK);
    }
}
