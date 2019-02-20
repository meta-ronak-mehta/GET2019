package com.metacube.ead1.factory;


import com.metacube.ead1.dao.ProductDao;
import com.metacube.ead1.facade.ProductFacade;
import com.metacube.ead1.model.Product;
import com.metacube.ead1.model.ShoppingCart;
import com.metacube.ead1.model.User;

public class DAOFactory {

    /**
     * create and return product
     * @param productCode of product
     * @param productType of product
     * @param productName of product
     * @param productPrice of product
     * @return product object
     */
    public static Product createProduct(int productCode, String productType, String productName,double productPrice){
        Product product=new Product (productCode, productType, productName, productPrice);
        
        return product;        
    }
    
    /**
     * create and return User Object
     * @param userId of user
     * @param username of user
     * @param userMobileno of user
     * @param emailAddress of user
     * @return object of User
     */
    public static User createUser(int userId, String username, int userMobileno, String emailAddress){
        User user =new User (userId, username, userMobileno,  emailAddress);
        
        return user;
    }
    
    public static ShoppingCart createShoppingCart(){
        ShoppingCart shoppingCart =new ShoppingCart();
        
        return shoppingCart;
    }
    public static ProductFacade createProductFacade(){
        return new ProductFacade();
    }
    
    public static ProductDao createProductDao(){
        return new ProductDao();
    }
    
}
