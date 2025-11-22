package com.example.itemcared.itemcard.exception;

public class CategoryFoundException  extends  RuntimeException {
    public CategoryFoundException(int id) {
        super("Category with ID " + id + " Already exists");
    }
}
