package com.ramsey.todolist.listservice.controller;

import com.ramsey.todolist.listservice.model.List;
import com.ramsey.todolist.listservice.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users/{username}/lists")
public class ListController {
	
	private final ListService listService;
	
	@GetMapping
	public ArrayList<List> getLists(
			@PathVariable String username
	) {
		
		return listService.getLists(username);
		
	}
	
	@GetMapping("{listName}")
	public List getList(
			@PathVariable String username,
			@PathVariable String listName
	) {
		
		return listService.getList(username, listName);
		
	}
	
	@PostMapping
	public List addList(
			@PathVariable String username,
			@RequestBody List list
	) {
		
		return listService.addList(username, list);
		
	}
	
	@PutMapping("{listName}")
	public List updateList(
			@PathVariable String username,
			@PathVariable String listName,
			@RequestBody List list
	) {
		
		return listService.updateList(username, listName, list);
		
	}
	
	@DeleteMapping("{listName}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteList(
			@PathVariable String username,
			@PathVariable String listName
	) {
		
		listService.deleteList(username, listName);
		
	}
	
}
