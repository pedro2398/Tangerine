package com.tangerineAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tangerineAPI.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}