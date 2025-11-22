package com.example.itemcared.itemcard.controller;

import com.example.itemcared.itemcard.model.Category;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.itemcared.itemcard.service.ItemCardService;

import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CateogryController {

    private final ItemCardService service;

    public CateogryController(ItemCardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category created = service.createCategory(category);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id) {
        return service.getCategory(id);
    }

    @GetMapping
    public Collection<Category> getAllCategories() {
        return service.getAllCategories();
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
        return service.updateCategory(id, category.getName());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
        service.deleteCategory(id);
    }
}
