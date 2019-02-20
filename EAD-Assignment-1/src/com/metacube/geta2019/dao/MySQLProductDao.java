package com.metacube.geta2019.dao;

import java.util.Map;

import com.metacube.geta2019.enums.Status;
import com.metacube.geta2019.model.Product;

public class MySQLProductDao implements BaseDao<Product> {



    
    /**
     * Method create a new product
     * @return status for product added or not
     * 
     */
    @Override
    public Status createProduct(int productCode, String productType, String productName,double productPrice,int productStock) {
        return Status.ERROR;
    }
    
    /**
     * Method to return the list of T objects
     * @return list
     * 
     */
    @Override
    public Map<Product,Integer> getAllProduct() {
        return null;
    }

    /**
     * method to update details of product
     * @return status for product updated or not
     */
    @Override
    public Status updateProduct(int productCode, String productType, String productName,double productPrice,int productStock) {
        return Status.ERROR;    
    }

    /**
     *  method to delete product
     * @return status for product deleted or not
     */
    @Override
    public Status deleteProduct(int id) {
        return Status.ERROR;
    }

    @Override
    public Status addProductToCart(int productID, int productQuantity) {
        return Status.ERROR;
    }

    @Override
    public Map<Product, Integer> getCart() {
        return null;
    }

    @Override
    public Status updateProductToCart(int productID, int productQuantity) {
        return Status.ERROR;
    }

    @Override
    public Status deleteProductFromCart(int productID) {
        return Status.ERROR;
    }
    

}
