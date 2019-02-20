package com.metacube.ead1.controller;

import java.util.Map;

import com.metacube.ead1.enums.DBType;
import com.metacube.ead1.enums.Status;
import com.metacube.ead1.facade.ProductFacade;
import com.metacube.ead1.factory.DAOFactory;
import com.metacube.ead1.model.Product;

public class ProductController {
    ProductFacade facade=DAOFactory.createProductFacade();
    
    /**
     * Method create a new product
     * @param dbType type of database where data is store
     * @param productCode unique product code
     * @param productType of product
     * @param productName name of product
     * @param productPrice price if product
     * @param productStock available quantity
     * @return status for product added or not
     */
    public Status createProduct(DBType dbType, int id, String type,String name, double price, int stock){
        return  facade.createProduct(dbType, id, type, name, price, stock);
    }
    
    /**
     * Method to return the list of Product and  available stock
     * @return list the list of Product and  available stock
     * 
     */
    public Map<Product,Integer> getProducts(){
        return facade.getProducts();
    }
    
    /**
     * 
     * @param id unique product code
     * @param type of product
     * @param name name of product
     * @param price price if product
     * @param stock  available quantity
     * @return status for product updated or not
     */
    public Status updateProduct(int id, String type,String name, double price, int stock){
        return facade.updateProduct(id, type,name, price, stock);
    }
    
    /**
     * Method to delete product
     * @param id of product to be deleted
     * @return status of product deleted or not
     */
    public Status deleteProduct(int id){
        return facade.deleteProduct(id);
    }
    
    /**
     * method to add product into cart
     * @param productID of product to be added
     * @param productQuantity of product
     * @return status of product added to cart or not
     */
    public Status addProductToCart(int productID,int productQuantity){
        return facade.addProductToCart(productID, productQuantity);
    }
    
    /**
     * method to get cart items with quantity
     * @return  cart items with quantity
     */
    public Map<Product,Integer> getCartItem(){
        return facade.getCartItem();
    }
    
    /**
     * 
     * @param productID of product to be updated
     * @param productQuantity of product 
     * @return status of cart updated or not
     */
    public Status updateProductToCart(int productID,int productQuantity){
        return facade.updateProductToCart(productID, productQuantity);
    }
    
    /**
     * 
     * @param productID of product to be deleted
     * @return status of product deleted from cart or not
     */
    public Status deleteProductFromCart(int productID){
        return facade.deleteProductFromCart(productID);
    }
}
