package com.istore.istoreproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.istore.istoreproject.models.Product;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product , Long> {

    @Query("select p from Product p where p.question.question_id = ?1")
    List<Product> findByQuestionId(long id);

    
}
