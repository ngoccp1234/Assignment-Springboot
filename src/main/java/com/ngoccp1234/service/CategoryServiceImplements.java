package com.ngoccp1234.service;

import com.ngoccp1234.entity.Category;
import com.ngoccp1234.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplements implements CategoryService {
private static final String currentTime = new SimpleDateFormat("dd-MM-yyyy HH:mm ").format(Calendar.getInstance().getTime());

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAllCategory();
    }

    @Override
    public Category saveCategory(Category category) {
        category.setCreatedAt(currentTime);
        category.setStatus(1);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        category.setUpdatedAt(currentTime);
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryId(int id) {
        return categoryRepository.findCategoryById(id);
    }
}
