package com.ramsey.todolist.todoservice.error;

public class TodoNotFoundError extends Error {
	
	public TodoNotFoundError(Long todoId) {
		
		super(String.format("Todo %d, was not found", todoId));
		
	}
	
}
