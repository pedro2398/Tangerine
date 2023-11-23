package com.tangerineAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tangerineAPI.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}