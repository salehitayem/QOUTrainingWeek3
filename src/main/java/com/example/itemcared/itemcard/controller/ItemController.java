package com.example.itemcared.itemcard.controller;


import com.example.itemcared.itemcard.model.Item;
import com.example.itemcared.itemcard.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.itemcared.itemcard.service.ItemCardService;

import java.util.Collection;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemCardService service;
    private final CategoryRepository categoryRepository;

    public ItemController(ItemCardService service, CategoryRepository categoryRepository) {
        this.service = service;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item created = service.createItem(item);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{barcode}")
    public Item getItem(@PathVariable String barcode) {
        return service.getItem(barcode);
    }

    @GetMapping
    public Collection<Item> getAllItems() {
        return service.getAllItems();
    }

    @PutMapping("/{barcode}")
    public Item updateItem(@PathVariable String barcode, @RequestBody Item item) {
        return service.updateItem(barcode, item.getName(), item.getPrice(), item.getCategoryId());
    }

    @DeleteMapping("/{barcode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable String barcode) {
        service.deleteItem(barcode);
    }
}
