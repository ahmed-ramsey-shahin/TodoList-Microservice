package com.ramsey.todolist.listservice.service;

import java.util.ArrayList;
import java.util.Optional;

import com.ramsey.todolist.listservice.client.UserClient;
import com.ramsey.todolist.listservice.error.ListAlreadyExistsError;
import com.ramsey.todolist.listservice.error.ListNotFoundError;
import com.ramsey.todolist.listservice.model.List;
import com.ramsey.todolist.listservice.pojo.User;
import com.ramsey.todolist.listservice.repo.ListRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListService {

    private final ListRepo listRepo;
    private final UserClient userClient;

    private User getUser(String username) {

        return userClient.getUser(username);

    }

    private Boolean listExists(String username, String listName) {

        try {

            getList(username, listName);

        } catch(ListNotFoundError err) {

            return false;

        }

        return true;

    }

    public ArrayList<List> getLists(String username) {

        User user = getUser(username);
        return listRepo.findByUserId(user.getId());

    }

    public List getList(String username, String listName) {

        User user = getUser(username);
        Optional<List> list = listRepo.findByUserIdAndName(user.getId(), listName);

        if(list.isEmpty()) {

            throw new ListNotFoundError(listName);

        }

        return list.get();

    }

    public List addList(String username, List list) {

        User user = getUser(username);

        if(!listExists(username, list.getName())) {

            return listRepo.save(list.withUserId(user.getId()));

        }

        throw new ListAlreadyExistsError(list.getName());

    }

    public List updateList(String username, String listName, List list) {

        List oldList = getList(username, listName);
        
        if(!list.getName().equalsIgnoreCase(listName)) {

            if(!listExists(username, list.getName())) {

                return listRepo.save(
                    oldList.withName(list.getName())
                );

            }

            throw new ListAlreadyExistsError(list.getName());

        }

        return list;

    }
    
    public void deleteList(String username, String listName) {

        listRepo.delete(
            getList(username, listName)
        );

    }

}
