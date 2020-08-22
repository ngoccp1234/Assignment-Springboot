package com.ngoccp1234.repository;

import com.ngoccp1234.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select c from Category c where c.status = 1")
    List<Category> findAllCategory();

    @Query("select c from Category  c where c.id =:id and c.status = 1")
    Category findCategoryById(int id);

}
