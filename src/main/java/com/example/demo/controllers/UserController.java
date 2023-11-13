package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getUsers")
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/getUser/{id}")
    public Optional<User> getUserById(@PathVariable Long id)
    {
        return userRepository.findById(id);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user)
    {
        userRepository.save(user);
    }



}
