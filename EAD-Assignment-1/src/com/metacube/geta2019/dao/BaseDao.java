package com.metacube.geta2019.dao;
import com.metacube.geta2019.enums.Status;

import java.util.Map;

import com.metacube.geta2019.model.BaseEntity;
import com.metacube.geta2019.model.Product;

public interface BaseDao<T extends BaseEntity> {
    
    
    
    /**
     * Method create a new product
     * @return status for product added or not
     * 
     */
    public Status createProduct(int productCode, String productType, String productName,double productPrice,int productStock);    
  
    /**
     * Method to return the list of T objects
     * @return list
     * 
     */
    public Map<T,Integer> getAllProduct();
    
    /**
     * method to update details of product
     * @return status for product updated or not
     */
    public Status updateProduct(int id, String productType, String productName,double productPrice,int productStock);
    
    /**
     *  method to delete product
     * @return status for product deleted or not
     */
    public Status deleteProduct(int id);
     
    /**
     * 
     * @param productID id of product to be added
     * @param productQuantity quantity of 
     * @return
     */
    public Status addProductToCart(int productID , int productQuantity);
    
    public Map<Product,Integer> getCart();
    
    public Status updateProductToCart(int productID , int productQuantity);
    
    public Status deleteProductFromCart(int productID);
    

}
