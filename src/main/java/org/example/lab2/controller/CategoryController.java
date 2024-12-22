package org.example.lab2.controller;

import org.example.lab2.model.Category;
import org.example.lab2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Отримати всі категорії
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Отримати категорію за ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getAllCategories().stream()
                .filter(category -> category.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // Створити нову категорію
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // Оновити існуючу категорію
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        return categoryService.getAllCategories().stream()
                .filter(category -> category.getId().equals(id))
                .findFirst()
                .map(category -> {
                    category.setName(updatedCategory.getName());
                    return categoryService.createCategory(category);
                })
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // Видалити категорію
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.getAllCategories().stream()
                .filter(category -> category.getId().equals(id))
                .findFirst()
                .ifPresent(category -> categoryService.deleteAllCategories());
        return "Category deleted successfully";
    }
}
