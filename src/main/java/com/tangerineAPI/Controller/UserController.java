package com.tangerineAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tangerineAPI.model.User;
import com.tangerineAPI.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping
    public List<User> getUser() {
        System.out.println("All users");
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody @Valid User user) {
        System.out.println("Signing up user"); 
        repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping( "{id}" )
    public ResponseEntity<User> getUserId(@PathVariable Long id) {
        System.out.println("User with id: " + id);
        
        return ResponseEntity.ok(getUserdById(id));
    }

    @DeleteMapping( "{id}" )
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        System.out.println("Deleting user with id " + id);
        
        getUserdById(id);
        repository.deleteById(id);
        
        return ResponseEntity.noContent().build();   
    }

    @PutMapping( "{id}" )
    public ResponseEntity<User> putUser(@PathVariable Long id, @RequestBody @Valid User newUser) {
        System.out.println("Changing user with id " + id);
        
        getUserdById(id);
        newUser.setId(id);
        repository.save(newUser);

        return ResponseEntity.ok(newUser);
    }

    private User getUserdById(Long id) {
        return repository.findById(id).orElseThrow( () -> {
            return new RuntimeException();
        } );
    }
}
