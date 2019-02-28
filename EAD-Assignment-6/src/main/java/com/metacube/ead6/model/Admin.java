package com.metacube.ead6.model;

public class Admin {
    
    String username;
    String password;

    public Admin() {
        super();
    }
    
    public Admin(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    
    // Getter and Setter methods
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    

}
