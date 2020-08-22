package com.ngoccp1234.repository;

import com.ngoccp1234.entity.Category;
import com.ngoccp1234.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select c from Product c where c.status = 1")
    List<Product> findAllProduct();

    @Query("select c from Product c where c.id =:id and c.status = 1")
    Product findProductId(int id);

}
