package com.ramsey.todolist.listservice.error;

public class ListAlreadyExistsError extends Error {
    
    public ListAlreadyExistsError(String name) {

        super(String.format("List %s, already exists", name));

    }

}
