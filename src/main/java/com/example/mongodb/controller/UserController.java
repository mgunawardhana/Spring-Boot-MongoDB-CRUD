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

    /**
     * Handles HTTP POST requests to save a User object.
     *
     * @param user the User object to be saved, provided in the request body
     * @return a success message indicating the User was saved
     */
    @PostMapping("/saveUser")
    public String saveBook(@RequestBody User user) {
        System.out.println("User from Controller: " + user);
        User save = userRepo.save(user);
        System.out.println("User saved from Controller: " + save);
        return "User saved successfully";
    }

    /**
     * Handles HTTP GET requests to fetch all User objects.
     *
     * @return a list of all User objects from the database
     */
    @GetMapping("/fetchAll")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    /**
     * Handles HTTP GET requests to fetch a User object by its ID.
     *
     * @param id the ID of the User to be fetched, provided in the URL path
     * @return the User object with the specified ID, or null if not found
     */
    @GetMapping("/fetchBy/{id}")
    public User getBookById(@PathVariable ObjectId id) {
        return userRepo.findById(id).orElse(null);
    }

    /**
     * Handles HTTP DELETE requests to delete a User object by its ID.
     *
     * @param id the ID of the User to be deleted, provided in the URL path
     * @return a success message indicating the User was deleted
     */
    @DeleteMapping("/deleteBy/{id}")
    public String deleteBook(@PathVariable ObjectId id) {
        userRepo.deleteById(id);
        return "User deleted successfully id: " + id;
    }

}
