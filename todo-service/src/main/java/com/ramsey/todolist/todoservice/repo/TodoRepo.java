package com.ramsey.todolist.todoservice.repo;

import com.ramsey.todolist.todoservice.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface TodoRepo extends CrudRepository<Todo, Long> {
	
	Optional<Todo> findByListIdAndId(Long listId, Long todoId);
	ArrayList<Todo> findByListId(Long listId);
	
}
