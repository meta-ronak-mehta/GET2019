package com.metacube.geta2019.factory;

import java.util.Map;

import com.metacube.geta2019.model.Product;
import com.metacube.geta2019.model.ShoppingCart;
import com.metacube.geta2019.model.User;

public class DAOFactory {

    public static Product createProduct(int productCode, String productType, String productName,double productPrice){
        Product product=new Product (productCode, productType, productName, productPrice);
        
        return product;        
    }
    
    public static ShoppingCart createShoppingCart(int id,Map<Product, Integer> productsInCart){
        ShoppingCart cart =new ShoppingCart(id, productsInCart);
        
        return cart; 
    }
    
    public static User createUser(int userId, String username, int userMobileno, String emailAddress){
        User user =new User (userId, username, userMobileno,  emailAddress);
        
        return user;
    }
}
