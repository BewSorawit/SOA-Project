package com.example.project.service;

import java.util.List;
import java.util.Locale.Category;

public interface CategoryService {
    Category createCategory(Category category);

    Category getCategoryById(int id);

    List<Category> getAllCategories();

    Category updateCategory(int id, Category category);

    void deleteCategory(int id);
}
