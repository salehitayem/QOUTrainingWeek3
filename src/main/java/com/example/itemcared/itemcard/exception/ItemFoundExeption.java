package com.example.itemcared.itemcard.exception;

public class ItemFoundExeption  extends  RuntimeException {
    public ItemFoundExeption(String barcode) {
        super("Item with barcode " + barcode + " already exists");
    }
}
