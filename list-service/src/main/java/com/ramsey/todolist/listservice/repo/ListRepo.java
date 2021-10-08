package com.ramsey.todolist.listservice.repo;

import java.util.ArrayList;
import java.util.Optional;

import com.ramsey.todolist.listservice.model.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepo extends CrudRepository<List, Long> {

    ArrayList<List> findByUserId(Long userId);
    Optional<List> findByUserIdAndName(Long userId, String listName);

}
