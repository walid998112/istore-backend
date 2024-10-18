package com.istore.istoreproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istore.istoreproject.models.Camera;


public interface CameraRepo extends JpaRepository<Camera , Long> {
    
}
