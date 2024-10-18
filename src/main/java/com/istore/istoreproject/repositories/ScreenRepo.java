package com.istore.istoreproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istore.istoreproject.models.Screen;


public interface ScreenRepo extends JpaRepository<Screen , Long> {
    
}
