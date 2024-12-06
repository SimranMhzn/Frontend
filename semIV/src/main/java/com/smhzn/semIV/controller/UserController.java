package com.smhzn.semIV.controller;

import com.smhzn.semIV.model.User;
import com.smhzn.semIV.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list") //http method aksto use garne bhanera define gareko
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        userService.add(user);
        return user;
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id) {
        try {
            return userService.updateUser(user, id); // Return the updated user object directly
        } catch (Exception e) {
            throw new RuntimeException("Failed to update user"); // This will return a default 500 error
        }
    }

    @GetMapping("/list/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @GetMapping("/retrieve")
    public int getCurrentUserId() {
        User currentUser = userService.getCurrentUser();
        return currentUser.getUserId(); // Return only the user ID
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        try {
            userService.deleteById(id); // Perform the delete operation
            return "User deleted successfully"; // Return a success message
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete user"); // This will return a default 500 error
        }
    }
}

