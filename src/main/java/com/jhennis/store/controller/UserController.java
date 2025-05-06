package com.jhennis.store.controller;

import com.jhennis.store.repo.UserRepo;
import com.jhennis.store.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Long id) {
        if(userRepo.findById(id).isEmpty()) {
            throw new NoSuchElementException("User not found/Id DNE");
        }
        return userRepo.findById(id).get();
    }

    @PostMapping("/users/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        userRepo.save(user);

    }

    @DeleteMapping("users/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@RequestBody User user) {
        userRepo.delete(user);
    }
}
