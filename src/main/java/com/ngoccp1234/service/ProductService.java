package com.ngoccp1234.service;

import com.ngoccp1234.entity.Category;
import com.ngoccp1234.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    Product getProductId(int id);
}
