package com.tangerineAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tangerineAPI.Model.User;
import com.tangerineAPI.Repository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/user")
    public List<User> getUser() {
        System.out.println("All users");
        return repository.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<User> postUser(@RequestBody @Valid User user) {
        System.out.println("Signing up user"); 
        repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
