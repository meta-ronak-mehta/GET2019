package com.metacube.ead7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.ead7.dao.AdminDAO;


@Service
public class AdminService {
    
    @Autowired
    private AdminDAO adminDao;
    
    /**
     * 
     * @param username of admin
     * @param password of admin
     * @return true if this credentials matches in database
     */
    public boolean isValidAdmin(String username, String password){
        return adminDao.isValidAdmin(username, password);
    }

}
