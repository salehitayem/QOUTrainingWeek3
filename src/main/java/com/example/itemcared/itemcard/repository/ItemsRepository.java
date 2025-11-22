package com.example.itemcared.itemcard.repository;

import com.example.itemcared.itemcard.model.Item;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemsRepository {
    private final Map<String, Item> items = new HashMap<>();

    public void save(Item item) {
        items.put(item.getBarcode(), item);
    }

    public boolean existsByBarcode(String barcode) {
        return items.containsKey(barcode);
    }

    public Item findByBarcode(String barcode) {
        return  items.get(barcode);
    }

    public Collection<Item> getAll() {
        return items.values();
    }
    public void deleteByBarcode(String barcode) {
        items.remove(barcode);
    }

}
