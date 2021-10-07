package com.ramsey.todolist.userservice.error;

public class UserNotFoundError extends Error {
    
    public UserNotFoundError(String username) {

        super(String.format("User %s, was not found", username));

    }

    public UserNotFoundError(Long id) {

        super(String.format("User %d, was not found", id));

    }

}
