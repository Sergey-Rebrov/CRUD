package com.firsttask.service;

import com.firsttask.dao.UserDAO;
import com.firsttask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sergey on 20.11.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }


    @Transactional
    public User getUserByID(int id) {
        return userDAO.getUserByID(id);
    }

    @Transactional
    public List<User> listUsers(String search, Integer offset, Integer maxResults) {
        return userDAO.listUsers(search, offset, maxResults);
    }

    @Transactional
    public Long countUsers(String search) {
        return userDAO.countUsers(search);
    }

}
