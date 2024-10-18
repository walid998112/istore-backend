package com.istore.istoreproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.istore.istoreproject.models.Image;


public interface ImageRepo extends JpaRepository<Image, Long> {

    @Query("select i from Image i where product.product_id = ?1")
    List<Image> findByProductId(long id);

}
