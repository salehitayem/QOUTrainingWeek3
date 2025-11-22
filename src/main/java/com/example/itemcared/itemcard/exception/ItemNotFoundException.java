package com.example.itemcared.itemcard.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String barcode) {
        super("Item with barcode " + barcode + "Not found");
    }
}
