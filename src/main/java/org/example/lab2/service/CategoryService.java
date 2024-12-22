package org.example.lab2.service;

import org.springframework.transaction.annotation.Transactional;
import org.example.lab2.model.Category;
import org.example.lab2.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Transactional
    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }
}


