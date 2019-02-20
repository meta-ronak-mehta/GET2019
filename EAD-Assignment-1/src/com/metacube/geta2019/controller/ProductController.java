package com.metacube.geta2019.controller;

import java.util.Map;

import com.metacube.geta2019.enums.DBType;
import com.metacube.geta2019.enums.Status;
import com.metacube.geta2019.facade.ProductFacade;
import com.metacube.geta2019.model.Product;

public class ProductController {
    ProductFacade fasade;
    
    public Status createProduct(DBType dbType, int id, String type,String name, double price, int stock){
        return fasade.createProduct(dbType, id, type, name, price, stock);
    }
    
    public Map<Product,Integer> getProducts(){
        return fasade.getProducts();
    }
    
    public Status updateProduct(int id, String type,String name, double price, int stock){
        return fasade.updateProduct(id, type,name, price, stock);
    }
    
    
    public Status deleteProduct(int id){
        return fasade.deleteProduct(id);
    }
    
    public Status addProductToCart(int productID,int productQuantity){
        return fasade.addProductToCart(productID, productQuantity);
    }
    
    public Map<Product,Integer> getCartItem(){
        return fasade.getCartItem();
    }
    
    
    public Status updateProductToCart(int productID,int productQuantity){
        return fasade.updateProductToCart(productID, productQuantity);
    }
    
    
    public Status deleteProductFromCart(int productID){
        return fasade.deleteProductFromCart(productID);
    }
}
