package com.istore.istoreproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istore.istoreproject.models.Connectivity;


public interface ConnectivityRepo extends JpaRepository<Connectivity , Long>{
    
}
