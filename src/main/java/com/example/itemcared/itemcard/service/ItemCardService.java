package com.example.itemcared.itemcard.service;

import com.example.itemcared.itemcard.exception.CategoryFoundException;
import com.example.itemcared.itemcard.exception.CategoryNotFoundException;
import com.example.itemcared.itemcard.exception.ItemFoundExeption;
import com.example.itemcared.itemcard.exception.ItemNotFoundException;
import com.example.itemcared.itemcard.model.Category;
import com.example.itemcared.itemcard.model.Item;
import org.springframework.stereotype.Service;
import com.example.itemcared.itemcard.repository.CategoryRepository;
import com.example.itemcared.itemcard.repository.ItemsRepository;

import java.util.Collection;

@Service
public class ItemCardService {
    private final ItemsRepository itemsRepository;
    private final CategoryRepository categoryRepository;


    public ItemCardService(ItemsRepository itemsRepository, CategoryRepository categoryRepository) {
        this.itemsRepository = itemsRepository;
        this.categoryRepository = categoryRepository;
    }


    // handling items operations
    public Item createItem(Item item) {
        if (itemsRepository.existsByBarcode(item.getBarcode())) {
            throw new ItemFoundExeption(item.getBarcode());
        }
        if (!categoryRepository.existsById(item.getCategoryId())) {
            throw new CategoryNotFoundException(item.getCategoryId());
        }
        itemsRepository.save(item);
        return item;
    }

    public Item getItem(String barcode) {
        Item item = itemsRepository.findByBarcode(barcode);
        if (item == null) {
            throw new ItemNotFoundException(barcode);
        }
        return item;
    }

    public Collection<Item> getAllItems() {
        return itemsRepository.getAll();
    }

    public Item updateItem(String barcode, String newName, double newPrice, int categoryId) {
        Item itemExisting = itemsRepository.findByBarcode(barcode);
        if (itemExisting== null) {
            throw new ItemNotFoundException(barcode);
        }
        Category catExisting = categoryRepository.getById(categoryId);
        if (catExisting == null) {
            throw new CategoryFoundException(categoryId);
        }
        Item updated = new Item(barcode, newName, newPrice, categoryId);
        itemsRepository.save(updated);
        return updated;
    }

    public void deleteItem(String barcode) {
        if (!itemsRepository.existsByBarcode(barcode)) {
            throw new ItemNotFoundException(barcode);
        }
        itemsRepository.deleteByBarcode(barcode);
    }

    // hanndling category operations
    public Category createCategory(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            throw new CategoryFoundException(category.getId());
        }
        categoryRepository.save(category);
        return category;
    }

    public Category getCategory(int id) {
        Category category = categoryRepository.getById(id);
        if (category == null) {
            throw new CategoryNotFoundException(id);
        }
        return category;
    }

    public Collection<Category> getAllCategories() {
        return categoryRepository.getAll();
    }

    public Category updateCategory(int id, String newName) {
        Category existing = categoryRepository.getById(id);
        if (existing == null) {
            throw new CategoryNotFoundException(id);
        }

        Category updated = new Category(id, newName);
        categoryRepository.save(updated);
        return updated;
    }

    public void deleteCategory(int id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException(id);
        }
        categoryRepository.deleteById(id);
    }

}
