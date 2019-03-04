package com.metacube.ead8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.ead8.model.User;
import com.metacube.ead8.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 
     * @param user
     *            to be added
     * @return true if user added successfully
     */
    public boolean add(User user) {
        try {
            User u = userRepository.save(user);
            if (u != null)
                return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 
     * @param id
     *            of user to be required
     * @return user of that id
     */
    public User get(Integer id) {
        try {
            return userRepository.findOne(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @param user
     *            to be updated
     * @return true if user details updated successfully
     */

    public boolean update(User user) {
        try {
            User u = userRepository.save(user);
            if (u != null)
                return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 
     * @return list of all user
     */
    public List<User> getAll() {
        try {
            return userRepository.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @param id
     *            of user to be deleted
     * @return true if user deleted from database
     */
    public boolean delete(Integer id) {
        try {
            userRepository.delete(id);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 
     * @param attribute
     *            to be compare with
     * @param value
     *            of that attribute
     * @return list of user satisfy the condition
     */
    public List<User> getByAttribute(String attribute, String value) {
        try {
            if (attribute.equals("first_name"))
                return userRepository.findAllByFirstName(value);
            else if (attribute.equals("last_name"))
                return userRepository.findAllByLastName(value);
            else if (attribute.equals("contact_no"))
                return userRepository.findAllByContactNo(value);
            else if (attribute.equals("email"))
                return userRepository.findAllByEmail(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
