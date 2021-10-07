package com.ramsey.todolist.userservice.repo;

import java.util.Optional;

import com.ramsey.todolist.userservice.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
