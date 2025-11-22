package com.example.itemcared.itemcard.exception;

public class CategoryNotFoundException extends  RuntimeException {
    public CategoryNotFoundException(int id) {
        super("Category with ID " + id + " not found");
    }
}
