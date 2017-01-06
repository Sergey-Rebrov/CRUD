package com.firsttask.dao;

import com.firsttask.model.User;

import java.util.List;

/**
 * Created by Sergey on 20.11.2016.
 */
public interface UserDAO {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserByID(int id);

    public List<User> listUsers(String search, Integer offset, Integer maxResults);

    public Long countUsers(String search);
}
