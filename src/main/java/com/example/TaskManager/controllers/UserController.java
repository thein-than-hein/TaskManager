package com.example.TaskManager.controllers;

import com.example.TaskManager.entities.User;
import com.example.TaskManager.services.UserService;
import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/users")
    User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(path = "/users")
    List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/users/{userId}")
    User findById(@PathVariable String userId) {
        return userService.findById(userId);
    }

    @DeleteMapping(path = "/users/{userId}")
    void deleteById(@PathVariable String userId) {
        userService.deleteById(userId);
    }

    @ExceptionHandler(PropertyValueException.class)
    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, value = HttpStatus.NOT_ACCEPTABLE)
    public String propertyValueExceptionHandler(PropertyValueException e) {
        return e.getMessage();
    }
}
