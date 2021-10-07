package com.ramsey.todolist.userservice.handler;

import com.ramsey.todolist.userservice.pojo.ErrorResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {

        ErrorResponse errorResponse = new ErrorResponse()
            .withStatus(HttpStatus.FORBIDDEN.value())
            .withMessage("Could not do this operation");
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body(errorResponse);

    }

}
