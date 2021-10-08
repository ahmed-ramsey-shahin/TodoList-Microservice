package com.ramsey.todolist.listservice.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramsey.todolist.listservice.pojo.ErrorResponse;
import feign.FeignException;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FeignHandler {
	
	@SneakyThrows
	private ResponseEntity<?> handleNotFoundException(FeignException ex) {
		
		return ResponseEntity.status(ex.status())
				.body(
						new ObjectMapper().readValue(ex.contentUTF8(), ErrorResponse.class)
				);
		
	}
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<?> handleFeignException(FeignException ex) {
		
		if(ex.status() == 404) {
			
			return handleNotFoundException(ex);
			
		}
		
		return null;
		
	}
	
}
