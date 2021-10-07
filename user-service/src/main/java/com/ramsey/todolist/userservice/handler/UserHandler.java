package com.ramsey.todolist.userservice.handler;

import com.ramsey.todolist.userservice.error.UserNotFoundError;
import com.ramsey.todolist.userservice.pojo.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserHandler {
    
    @ExceptionHandler(UserNotFoundError.class)
    public ResponseEntity<?> handleUserNotFoundError(UserNotFoundError err) {

        ErrorResponse errorResponse = new ErrorResponse()
            .withStatus(HttpStatus.NOT_FOUND.value())
            .withMessage(err.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(errorResponse);

    }

}
