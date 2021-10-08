package com.ramsey.todolist.listservice.error;

public class ListNotFoundError extends Error {
    
    public ListNotFoundError(String name) {

        super(String.format("List \"%s\", was not found", name));

    }

}
