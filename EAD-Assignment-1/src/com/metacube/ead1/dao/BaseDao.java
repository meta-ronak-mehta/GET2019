package com.metacube.ead1.dao;
import com.metacube.ead1.enums.Status;
import com.metacube.ead1.model.BaseEntity;
import com.metacube.ead1.model.Product;

import java.util.Map;

public interface BaseDao<T extends BaseEntity> {
    
    
    
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
    public Status createProduct(int productCode, String productType, String productName,double productPrice,int productStock);    
  
    /**
     * Method to return the list of Product and  available stock
     * @return list the list of Product and  available stock
     * 
     */
    public Map<T,Integer> getAllProduct();
    
    /**
     * 
     * @param id unique product code
     * @param type of product
     * @param name name of product
     * @param price price if product
     * @param stock  available quantity
     * @return status for product updated or not
     */
    public Status updateProduct(int id, String productType, String productName,double productPrice,int productStock);
    
    /**
     * Method to delete product
     * @param id of product to be deleted
     * @return status of product deleted or not
     */
    public Status deleteProduct(int id);
     
    /**
     * method to add product into cart
     * @param productID of product to be added
     * @param productQuantity of product
     * @return status of product added to cart or not
     */
    public Status addProductToCart(int productID , int productQuantity);
    
    /**
     * method to get cart items with quantity
     * @return  cart items with quantity
     */
    public Map<Product,Integer> getCart();
    
    /**
     * 
     * @param productID of product to be updated
     * @param productQuantity of product 
     * @return status of cart updated or not
     */
    public Status updateProductToCart(int productID , int productQuantity);
    
    /**
     * 
     * @param productID of product to be deleted
     * @return status of product deleted from cart or not
     */
    public Status deleteProductFromCart(int productID);
    

}
