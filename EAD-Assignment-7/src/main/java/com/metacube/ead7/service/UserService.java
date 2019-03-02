package com.metacube.ead7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.ead7.dao.UserDAO;
import com.metacube.ead7.model.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    /**
     * 
     * @param user to be added
     * @return true if user added successfully
     */
    public boolean add(User user) {
        return userDAO.add(user);
    }

    /**
     * 
     * @param id of user to be required
     * @return user of that id
     */
    public User get(Integer id) {
        return userDAO.getUserByID(id);
    }

    /**
     * 
     * @param user to be updated
     * @return true if user details updated successfully
     */
    
    public boolean update(User user) {
        return userDAO.update(user);
    }

    /**
     * 
     * @return list of all user
     */
    public List<User> getAll() {
        return userDAO.getAll();
    }

    /**
     * 
     * @param id of user to be deleted
     * @return true if user deleted from database
     */
    public boolean delete(Integer id) {
        return userDAO.delete(id);
    }
    
    /**
     * 
     * @param attribute  to be compare with
     * @param value of that attribute
     * @return list of user satisfy the condition
     */
    public List<User> getByAttribute(String attribute , String Value){
        return userDAO.getByAttribute(attribute,Value);
    }

    
}
