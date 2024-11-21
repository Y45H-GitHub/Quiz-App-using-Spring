package com.example.LoginDemo.controller;

import com.example.LoginDemo.entity.UserDetails;
import com.example.LoginDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDetails user){
        if (userRepo.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
        }
        if (userRepo.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>("Email already registered", HttpStatus.BAD_REQUEST);
        }
        userRepo.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDetails user) {
        UserDetails existingUser = userRepo.findByUsername(user.getUsername());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

}
