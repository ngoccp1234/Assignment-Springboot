package com.ngoccp1234.service;

import com.ngoccp1234.entity.Product;
import com.ngoccp1234.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class ProductServiceImplements implements ProductService {
    private static final String currentTime = new SimpleDateFormat("dd-MM-yyyy HH:mm ").format(Calendar.getInstance().getTime());

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAllProduct();
    }

    @Override
    public Product saveProduct(Product product) {
        product.setCreatedAt(currentTime);
        product.setStatus(1);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        product.setUpdatedAt(currentTime);
        return productRepository.save(product);
    }

    @Override
    public Product getProductId(int id) {
        return productRepository.findProductId(id);
    }
}
