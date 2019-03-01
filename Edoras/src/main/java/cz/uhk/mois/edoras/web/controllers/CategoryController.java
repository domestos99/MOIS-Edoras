package cz.uhk.mois.edoras.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Optional;

import cz.uhk.mois.edoras.domain.Category;
import cz.uhk.mois.edoras.services.ICategoryService;

@RestController
public class CategoryController
{
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(final ICategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/categories")
    public ResponseEntity<ArrayList<Category>> getAll()
    {
        ArrayList<Category> payments = categoryService.getAll();
        return new ResponseEntity(payments, HttpStatus.OK);
    }

    @GetMapping("/api/category/{id}")
    public ResponseEntity<Category> getPaymentById(@PathVariable("id") String id)
    {
        Optional<Category> category = categoryService.getById(id);
        if (category.isPresent())
            return new ResponseEntity(category.get(), HttpStatus.OK);

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/api/category")
    public ResponseEntity<Category> insertCategory(@RequestBody Category category)
    {
        Category cat = categoryService.insert(category);
        if (cat == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(cat, HttpStatus.CREATED);
    }

    @PutMapping("/api/category/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category)
    {
        Category cat = categoryService.update(category);
        if (cat == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(cat, HttpStatus.OK);
    }

    @DeleteMapping("/api/category/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") String id)
    {
        boolean cat = categoryService.delete(id);
        if (cat)
            return new ResponseEntity(cat, HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
