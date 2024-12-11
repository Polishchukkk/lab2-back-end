package org.example.lab2.service;

import org.example.lab2.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final List<Category> categories = new ArrayList<>();

    public Category createCategory(Category category) {
        category.setId((long) (categories.size() + 1));
        categories.add(category);
        return category;
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public void deleteAllCategories() {
        categories.clear();
    }
}


