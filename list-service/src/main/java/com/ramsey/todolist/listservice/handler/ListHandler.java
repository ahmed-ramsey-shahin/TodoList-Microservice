package com.ramsey.todolist.listservice.handler;

import com.ramsey.todolist.listservice.error.ListAlreadyExistsError;
import com.ramsey.todolist.listservice.error.ListNotFoundError;
import com.ramsey.todolist.listservice.pojo.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ListHandler {
	
	@ExceptionHandler(ListAlreadyExistsError.class)
	public ResponseEntity<?> handleListAlreadyExistsError(ListAlreadyExistsError err) {
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
				.body(
						new ErrorResponse()
								.withMessage(err.getMessage())
								.withStatus(HttpStatus.FORBIDDEN.value())
				);
		
	}
	
	@ExceptionHandler(ListNotFoundError.class)
	public ResponseEntity<?> handleListNotFoundError(ListNotFoundError err) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(
						new ErrorResponse()
								.withMessage(err.getMessage())
								.withStatus(HttpStatus.NOT_FOUND.value())
				);
		
	}
	
}
