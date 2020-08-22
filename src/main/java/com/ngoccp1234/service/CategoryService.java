package com.ngoccp1234.service;

import com.ngoccp1234.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategory();

    Category saveCategory(Category category);

    Category updateCategory(Category category);

    Category getCategoryId(int id);
}
