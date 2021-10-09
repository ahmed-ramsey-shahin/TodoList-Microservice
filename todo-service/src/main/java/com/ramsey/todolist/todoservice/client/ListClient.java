package com.ramsey.todolist.todoservice.client;

import com.ramsey.todolist.todoservice.pojo.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("listservice")
public interface ListClient {
	
	@GetMapping("/v1/users/{username}/lists/{listName}")
	List getList(
			@PathVariable String username,
			@PathVariable String listName
	);
	
}
