package com.istore.istoreproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istore.istoreproject.models.CPU;


public interface CPURepo extends JpaRepository<CPU , Long> {
    
}
