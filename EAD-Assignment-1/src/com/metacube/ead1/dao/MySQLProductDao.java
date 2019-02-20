package com.metacube.ead1.dao;

import java.util.Map;

import com.metacube.ead1.enums.Status;
import com.metacube.ead1.model.Product;

public class MySQLProductDao implements BaseDao<Product> {
  
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
    @Override
    public Status createProduct(int productCode, String productType, String productName,double productPrice,int productStock) {
        return Status.ERROR;
    }
    
    /**
     * Method to return the list of Product and  available stock
     * @return list the list of Product and  available stock
     * 
     */
    @Override
    public Map<Product,Integer> getAllProduct() {
        return null;
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
    @Override
    public Status updateProduct(int productCode, String productType, String productName,double productPrice,int productStock) {
        return Status.ERROR;    
    }

    /**
     * Method to delete product
     * @param id of product to be deleted
     * @return status of product deleted or not
     */
    @Override
    public Status deleteProduct(int id) {
        return Status.ERROR;
    }

    /**
     * method to add product into cart
     * @param productID of product to be added
     * @param productQuantity of product
     * @return status of product added to cart or not
     */
    @Override
    public Status addProductToCart(int productID, int productQuantity) {
        return Status.ERROR;
    }

    /**
     * method to get cart items with quantity
     * @return  cart items with quantity
     */
    @Override
    public Map<Product, Integer> getCart() {
        return null;
    }

    /**
     * 
     * @param productID of product to be updated
     * @param productQuantity of product 
     * @return status of cart updated or not
     */
    @Override
    public Status updateProductToCart(int productID, int productQuantity) {
        return Status.ERROR;
    }

    /**
     * 
     * @param productID of product to be deleted
     * @return status of product deleted from cart or not
     */
    @Override
    public Status deleteProductFromCart(int productID) {
        return Status.ERROR;
    }
    

}
