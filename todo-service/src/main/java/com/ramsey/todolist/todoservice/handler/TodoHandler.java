package com.ramsey.todolist.todoservice.handler;

import com.ramsey.todolist.todoservice.error.TodoNotFoundError;
import com.ramsey.todolist.todoservice.pojo.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TodoHandler {
	
	@ExceptionHandler(TodoNotFoundError.class)
	public ResponseEntity<?> handleTodoNotFoundError(TodoNotFoundError err) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(
						new ErrorResponse()
								.withMessage(err.getMessage())
								.withStatus(HttpStatus.NOT_FOUND.value())
				);
		
	}
	
}
