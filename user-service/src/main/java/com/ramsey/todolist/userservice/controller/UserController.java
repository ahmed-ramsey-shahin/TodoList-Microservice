package com.ramsey.todolist.userservice.controller;

import com.ramsey.todolist.userservice.model.User;
import com.ramsey.todolist.userservice.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users")
public class UserController {
    
    private final UserService userService;

    @GetMapping("{username}")
    public User getUser(
        @PathVariable String username
    ) {

        return userService.getUser(username);

    }

    @PostMapping
    public User addUser(
        @RequestBody User user
    ) {

        return userService.addUser(user);

    }

    @PutMapping("{username}")
    public User updateUser(
        @PathVariable String username,
        @RequestBody User user
    ) {

        return userService.updateUser(username, user);

    }

    @DeleteMapping("{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(
        @PathVariable String username
    ) {

        userService.deleteUser(username);

    }

}
