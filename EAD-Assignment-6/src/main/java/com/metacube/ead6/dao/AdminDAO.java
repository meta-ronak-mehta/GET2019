package com.metacube.ead6.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.ead6.mapper.AdminMapper;
import com.metacube.ead6.model.Admin;

@Repository
public class AdminDAO {

    private JdbcTemplate jdbcTemplate;
    private final String SQL_SELECT_ADMIN ="select * from admin";

    
    @Autowired
    public AdminDAO(DataSource dataSource) {
        super();
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    /**
     * 
     * @param username of admin
     * @param password of admin
     * @return true if this credentials matches in database
     */
    public boolean isValidAdmin(String username, String password){
       List <Admin> admins = jdbcTemplate.query(SQL_SELECT_ADMIN, new AdminMapper()); 
       for(Admin ad: admins){
           if( username.equals(ad.getUsername()) && password.equals(ad.getPassword()))
               return true;
       }
       return false;
    }
}
