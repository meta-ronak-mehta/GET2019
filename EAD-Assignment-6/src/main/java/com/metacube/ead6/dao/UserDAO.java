package com.metacube.ead6.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.metacube.ead6.mapper.UserMapper;
import com.metacube.ead6.model.User;


@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_PROJECT = "select * from user where id = ?";
    private final String SQL_DELETE_PROJECT = "delete from user where id = ?";
    private final String SQL_UPDATE_PROJECT = "update user set first_name = ?, last_name = ?, contact_no  = ?, email  = ? where id = ?";
    private final String SQL_GET_ALL = "select * from user";
    private final String SQL_INSERT_PROJECT = "insert into user(first_name, last_name, contact_no, email) values(?,?,?,?)";

    @Autowired
    public UserDAO(DataSource dataSource) {
        super();
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 
     * @param user to be added
     * @return true if user added successfully
     */
    public boolean add(User user) {
        return jdbcTemplate.update(SQL_INSERT_PROJECT, user.getFirstName(), 
                user.getLastName(),user.getContactNo(), user.getEmail()) > 0;
    }
    
    /**
     * 
     * @param id of user to be required
     * @return user of that id
     */
    public User get(Integer id) {
        return jdbcTemplate.queryForObject(SQL_FIND_PROJECT, new Object[] { id }, new UserMapper());
    }

    /**
     * 
     * @return list of all user
     */
    public List<User> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new UserMapper());
    }
    
    /**
     * 
     * @param user to be updated
     * @return true if user details updated successfully
     */
    public boolean update(User user) {
        return jdbcTemplate.update(SQL_UPDATE_PROJECT, user.getFirstName(), 
                user.getLastName(), user.getContactNo(),user.getLastName(),user.getId()) > 0;
    }

    /**
     * 
     * @param id of user to be deleted
     * @return true if user deleted from database
     */
    public boolean delete(Integer id) {
        return jdbcTemplate.update(SQL_DELETE_PROJECT, id) > 0;
    }
    
    /**
     * 
     * @param attribute  to be compare with
     * @param value of that attribute
     * @return list of user satisfy the condition
     */
    public List<User> getByAttribute(String attribute, String value){
//        if(attribute.equals("first_name")){
//            return jdbcTemplate.query(SQL_FIND_BY_FIRST_NAME,new Object[] {value},new UserMapper());
//        }else if(attribute.equals(Attribute.last_name)){
//            return jdbcTemplate.query(SQL_FIND_BY_LAST_NAME,new Object[] {value},new UserMapper());
//        }else if(attribute.equals(Attribute.contact_no)){
//            return jdbcTemplate.query(SQL_FIND_BY_CONTECT_NO,new Object[] {value},new UserMapper());        }
//        else if(attribute.equals(Attribute.email)){
//                return jdbcTemplate.query(SQL_FIND_BY_EMAIL_ID,new Object[] {value},new UserMapper());
//        }
//        else
//            return null;
        return jdbcTemplate.query("select * from user where "+attribute +"=\""+ value +"\";"  ,new UserMapper());
    }
    
   
}
