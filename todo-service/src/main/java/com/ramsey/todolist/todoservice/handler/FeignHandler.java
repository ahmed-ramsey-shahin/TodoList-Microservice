package com.ramsey.todolist.todoservice.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramsey.todolist.todoservice.pojo.ErrorResponse;
import feign.FeignException;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FeignHandler {
	
	@SneakyThrows
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<?> handleFeignException(FeignException ex) {
		
		return ResponseEntity.status(ex.status())
				.body(
						new ObjectMapper().readValue(ex.contentUTF8(), ErrorResponse.class)
				);
		
	}
	
}
