package com.example.itemcared.itemcard.model;

import com.example.itemcared.itemcard.controller.CateogryController;

public class Item {
    private String barcode;
    private String name;
    private double price;
    private int categoryId;

    public Item(String barcode, String name, double price, int categoryId) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getBarcode() {
        return barcode;
    }
    public String getName() {
        return  name;
    }
    public double getPrice() {
        return price;
    }

    public int getCategoryId() {
        return categoryId;
    }


}
