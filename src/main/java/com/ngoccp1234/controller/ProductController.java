package com.ngoccp1234.controller;


import com.ngoccp1234.entity.Category;
import com.ngoccp1234.entity.Product;
import com.ngoccp1234.service.CategoryService;
import com.ngoccp1234.service.ProductService;
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
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, path = "/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategory());
        return "product/addProduct";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addProduct")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/updateProduct/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductId(id);
        model.addAttribute("productUpdate", product);
        model.addAttribute("categoriesProduct", categoryService.getAllCategory());
        return "product/updateProduct";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, @Validated Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "product/updateProduct";
        }
        productService.updateProduct(product);
        model.addAttribute("categories", productService.getAllProduct());
        return "redirect:/admin/products";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/deleteProduct/{id}")
    public String deleteForm(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductId(id);
        model.addAttribute("productDelete", product);
        return "product/deleteProduct";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductId(id);
        product.setStatus(-1);
        productService.updateProduct(product);
        model.addAttribute("products", productService.getAllProduct());
        return "redirect:/admin/products";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public String listProduct(Model model) {
        List<Product> list = productService.getAllProduct();
        model.addAttribute("products", list);
        return "product/listProduct";
    }
}
