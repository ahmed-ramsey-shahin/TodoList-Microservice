package com.ramsey.todolist.listservice.client;

import com.ramsey.todolist.listservice.pojo.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserClient {
    
    @GetMapping("/v1/users/{username}")
    User getUser(@PathVariable String username);

}
