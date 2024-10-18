package com.istore.istoreproject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istore.istoreproject.models._User;


public interface UserRepo extends JpaRepository<_User, Long> {
   
    Optional<_User> findByUsername(String username);

    Optional<_User> findByEmail(String email);

}
