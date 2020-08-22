package com.ngoccp1234.controller;


import com.ngoccp1234.entity.Category;
import com.ngoccp1234.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, path = "/addCategory")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/addCategory";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addCategory")
    public String saveCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/admin/categories";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/updateCategory/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        Category category = categoryService.getCategoryId(id);
        model.addAttribute("categoryUpdate", category);
        return "category/updateCategory";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/updateCategory/{id}")
    public String updateCategory(@PathVariable("id") int id, @Validated Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            category.setId(id);
            return "category/updateCategory";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories", categoryService.getAllCategory());
        return "redirect:/admin/categories";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/deleteCategory/{id}")
    public String deleteForm(@PathVariable("id") int id, Model model) {
        Category category = categoryService.getCategoryId(id);
        model.addAttribute("categoryDelete", category);
        return "category/deleteCategory";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") int id, Model model) {
       Category category = categoryService.getCategoryId(id);
       category.setStatus(-1);
       categoryService.updateCategory(category);
       model.addAttribute("categories", categoryService.getAllCategory());
       return "redirect:/admin/categories";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/categories")
    public String listCategory(Model model) {
        List<Category> list = categoryService.getAllCategory();
        model.addAttribute("categories", list);
        return "category/listCategory";
    }
//    @RequestMapping(method = RequestMethod.GET, path = "/categories")
//    public ResponseEntity<Iterable<Category>> listCategory() {
//        Iterable<Category> categories = categoryService.getAllCategory();
//        if (categories != null) {
//            return new ResponseEntity<>(categories, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, path = "/categories")
//    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
//        if (category != null) {
//            Category category1 = categoryService.saveCategory(category);
//            return new ResponseEntity<>(category1, HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, path = "/categories/{id}")
//    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
//        Optional<Category> optionalCategory = categoryService.getCategoryId(id);
//        if (optionalCategory.isPresent()) {
//            return new ResponseEntity<>(optionalCategory.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, path = "/categories/{id}")
//    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
//        Optional<Category> optionalCategory = categoryService.getCategoryId(id);
//        if (optionalCategory.isPresent()) {
//            Category category1 = optionalCategory.get();
//            category1.setName(category.getName());
//            category1.setCode(category.getCode());
//            category1.setUrl(category.getUrl());
//            category1.setCreatedAt(category.getCreatedAt());
//            category1.setStatus(category.getStatus());
//            category1.setUpdatedAt(category.getUpdatedAt());
//            categoryService.saveCategory(category);
//            return new ResponseEntity<>(optionalCategory.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, path = "/categories/{id}")
//    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
//        Optional<Category> optionalCategory = categoryService.getCategoryId(id);
//        if (optionalCategory.isPresent()) {
//            Category category = optionalCategory.get();
//            category.setStatus(-1);
//            categoryService.saveCategory(category);
//            return new ResponseEntity<>("Delete Success!", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Dog is not found or has been deleted!", HttpStatus.NOT_FOUND);
//    }
}
