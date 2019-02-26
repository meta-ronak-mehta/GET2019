package com.metacube.ead5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.ead5.dao.UserDAO;
import com.metacube.ead5.model.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean add(User user) {
        return userDAO.add(user);
    }

    public User get(Integer id) {
        return userDAO.get(id);
    }

    public boolean update(User user) {
        return userDAO.update(user);
    }

    public List<User> getAll() {
        return userDAO.getAll();
    }

    public boolean delete(Integer id) {
        return userDAO.delete(id);
    }
    
    public List<User> getByAttribute(String attribute , String Value){
        return userDAO.getByAttribute(attribute,Value);
    }

    
}
