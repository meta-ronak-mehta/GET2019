package com.metacube.ead8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.ead8.model.User;

public interface UserRepository  extends JpaRepository<User, Integer> {

    /** methods to find list of users satisfy condition 
     * 
     * @param value of corresponding Attribute
     * @return list of users satisfy condition
     */
    public List<User> findAllByFirstName(String value);
    public List<User> findAllByLastName(String value);
    public List<User> findAllByContactNo(String value);
    public List<User> findAllByEmail(String value);
}
