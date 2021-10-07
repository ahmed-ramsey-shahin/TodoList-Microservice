package com.ramsey.todolist.userservice.service;

import java.util.Optional;

import com.ramsey.todolist.userservice.error.UserNotFoundError;
import com.ramsey.todolist.userservice.model.User;
import com.ramsey.todolist.userservice.repo.UserRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepo userRepo;

    public User getUser(String username) {

        Optional<User> user = userRepo.findByUsername(username);

        if(user.isEmpty()) {

            throw new UserNotFoundError(username);

        }

        return user.get();

    }

    public User addUser(User user) {

        return userRepo.save(user);

    }

    public User updateUser(String username, User user) {

        User oldUser = getUser(username);
        oldUser.copy(user);
        return userRepo.save(oldUser);

    }

    public void deleteUser(String username) {

        User user = getUser(username);
        userRepo.delete(user);

    }

}
