package com.ramsey.todolist.todoservice.service;

import com.ramsey.todolist.todoservice.client.ListClient;
import com.ramsey.todolist.todoservice.error.TodoNotFoundError;
import com.ramsey.todolist.todoservice.model.Todo;
import com.ramsey.todolist.todoservice.pojo.List;
import com.ramsey.todolist.todoservice.repo.TodoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
	
	private final TodoRepo todoRepo;
	private final ListClient listClient;
	
	private List getList(String username, String listName) {
		
		return listClient.getList(username, listName);
		
	}
	
	public Todo getTodo(String username, String listName, Long todoId) {
		
		List list = getList(username, listName);
		Optional<Todo> todo = todoRepo.findByListIdAndId(list.getId(), todoId);
		
		if(todo.isEmpty()) {
			
			throw new TodoNotFoundError(todoId);
			
		}
		
		return todo.get();
		
	}
	
	public ArrayList<Todo> getTodos(String username, String listName) {
		
		List list = getList(username, listName);
		return todoRepo.findByListId(list.getId());
		
	}
	
	public Todo addTodo(String username, String listName, Todo todo) {
		
		List list = getList(username, listName);
		return todoRepo.save(todo.withListId(list.getId()));
		
	}
	
	public Todo updateTodo(String username, String listName, Long todoId, Todo todo) {
		
		Todo oldTodo = getTodo(username, listName, todoId);
		return todoRepo.save(
				oldTodo.withFinished(todo.getFinished())
						.withName(todo.getName())
		);
		
	}
	
	public void deleteTodo(String username, String listName, Long todoId) {
		
		todoRepo.delete(getTodo(username, listName, todoId));
		
	}
	
}
