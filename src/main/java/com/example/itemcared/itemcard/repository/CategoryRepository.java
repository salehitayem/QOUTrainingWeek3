package com.example.itemcared.itemcard.repository;

import com.example.itemcared.itemcard.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CategoryRepository {
    private final Map<Integer, Category> categories = new HashMap<>();

    public void save(Category category) {
        categories.put(category.getId(), category);
    }
    public boolean existsById(int id) {
        return categories.containsKey(id);
    }
    public Category getById(int id) {
        return categories.get(id);
    }
    public Collection getAll() {
        return categories.values();
    }
    public void deleteById(int id) {
        categories.remove(id);
    }

}
