package com.metacube.ead1.model;

import com.metacube.ead1.factory.DAOFactory;

public class User extends BaseEntity {
    
    private String username;
    private int userMobileno;
    private String emailAddress;
    private ShoppingCart cart =  DAOFactory.createShoppingCart() ;
    
    public User(int userId, String username, int userMobileno, String emailAddress) {
        super(userId);
        this.username = username;
        this.userMobileno = userMobileno;
        this.emailAddress = emailAddress;
    }
    
    public User(int id) {
        super(id);
    }

    // Getters and Setters Methods
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getUserMobileno() {
        return userMobileno;
    }
    public void setUserMobileno(int userMobileno) {
        this.userMobileno = userMobileno;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User [ID=" + getId() + ", username=" + username + ", userMobileno=" + userMobileno
                + ", emailAddress=" + emailAddress + ", cart=" + cart + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((cart == null) ? 0 : cart.hashCode());
        result = prime * result
                + ((emailAddress == null) ? 0 : emailAddress.hashCode());
        result = prime * result + userMobileno;
        result = prime * result
                + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (cart == null) {
            if (other.cart != null)
                return false;
        } else if (!cart.equals(other.cart))
            return false;
        if (emailAddress == null) {
            if (other.emailAddress != null)
                return false;
        } else if (!emailAddress.equals(other.emailAddress))
            return false;
        if (userMobileno != other.userMobileno)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    
}
