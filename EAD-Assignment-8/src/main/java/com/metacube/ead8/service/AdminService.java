package com.metacube.ead8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.ead8.model.Admin;
import com.metacube.ead8.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    /**
     * 
     * @param username
     *            of admin
     * @param password
     *            of admin
     * @return true if this credentials matches in database
     */
    public boolean isValidAdmin(String username, String password) {
        try {
            List<Admin> admins = adminRepository.findAll();
            for (Admin ad : admins) {
                if (username.equals(ad.getUsername())
                        && password.equals(ad.getPassword()))
                    return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
