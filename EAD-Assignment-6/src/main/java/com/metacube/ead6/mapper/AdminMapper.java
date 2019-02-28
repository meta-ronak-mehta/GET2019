package com.metacube.ead6.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.ead6.model.Admin;

public class AdminMapper implements RowMapper<Admin> {

    @Override
    public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
        Admin project = new Admin();
        project.setUsername(resultSet.getString("username"));
        project.setPassword(resultSet.getString("password"));
        return project;
    }

}
