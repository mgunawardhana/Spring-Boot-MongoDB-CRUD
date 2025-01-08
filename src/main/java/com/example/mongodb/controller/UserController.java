package com.example.mongodb.controller;

import com.example.mongodb.model.User;
import com.example.mongodb.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/saveUser")
    public String saveBook(@RequestBody User user) {
        System.out.println("User from Controller: " + user);
        User save = userRepo.save(user);
        System.out.println("User saved from Controller: "+ save);
        return "User saved successfully";
    }

    @GetMapping("/fetchAll")
    public List<User> getAllBooks() {
        return userRepo.findAll();
    }

    @GetMapping("/fetchBy/{id}")
    public User getBookById(@PathVariable ObjectId id) {
        return userRepo.findById(id).orElse(null);
    }

    @DeleteMapping("/deleteBy/{id}")
    public String deleteBook(@PathVariable ObjectId id) {
        userRepo.deleteById(id);
        return "User deleted successfully id: " + id;
    }

}
