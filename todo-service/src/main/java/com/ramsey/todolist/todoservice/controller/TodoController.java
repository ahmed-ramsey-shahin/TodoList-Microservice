package com.ramsey.todolist.todoservice.controller;

import com.ramsey.todolist.todoservice.model.Todo;
import com.ramsey.todolist.todoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users/{username}/lists/{listName}/todos")
public class TodoController {
	
	private final TodoService todoService;
	
	@GetMapping("{todoId}")
	public Todo getTodo(
			@PathVariable String username,
			@PathVariable String listName,
			@PathVariable Long todoId
	) {
		
		return todoService.getTodo(username, listName, todoId);
		
	}
	
	@GetMapping
	public ArrayList<Todo> getTodos(
			@PathVariable String username,
			@PathVariable String listName
	) {
		
		return todoService.getTodos(username, listName);
		
	}
	
	@PostMapping
	public Todo addTodo(
			@PathVariable String username,
			@PathVariable String listName,
			@RequestBody Todo todo
	) {
		
		return todoService.addTodo(username, listName, todo);
		
	}
	
	@PutMapping("{todoId}")
	public Todo updateTodo(
			@PathVariable String username,
			@PathVariable String listName,
			@PathVariable Long todoId,
			@RequestBody Todo todo
	) {
		
		return todoService.updateTodo(username, listName, todoId, todo);
		
	}
	
	@DeleteMapping("{todoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTodo(
			@PathVariable String username,
			@PathVariable String listName,
			@PathVariable Long todoId
	) {
		
		todoService.deleteTodo(username, listName, todoId);
		
	}
	
}
