package com.istore.istoreproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.istore.istoreproject.models.Category;


public interface CategoryRepo extends JpaRepository<Category , Long> {

    @Query("select c from Category c where c.parentCategory.category_id = ?1")
    List<Category> findByParentId(long id);
    
}
