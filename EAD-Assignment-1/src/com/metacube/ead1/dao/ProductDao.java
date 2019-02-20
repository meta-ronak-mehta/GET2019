package com.metacube.ead1.dao;

import java.util.Map;

import com.metacube.ead1.enums.DBType;
import com.metacube.ead1.enums.Status;
import com.metacube.ead1.model.Product;

public class ProductDao implements BaseDao<Product>{
    
    private BaseDao<Product> baseDao =new InMemoryProductDao();
    
    public ProductDao(){
    }
    
    public ProductDao(DBType dbtype) {
        if(dbtype ==DBType.IN_MEMORY)
            baseDao=new InMemoryProductDao();
        else
            baseDao=new MySQLProductDao();            
    }


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
         return baseDao.createProduct(productCode, productType, productName, productPrice,productStock);
    }

    /**
     * Method to return the list of Product and  available stock
     * @return list the list of Product and  available stock
     * 
     */
    @Override
    public Map<Product,Integer> getAllProduct() {
        return baseDao.getAllProduct();
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
    public Status updateProduct(int id, String productType, String productName,double productPrice,int productStock) {
        return baseDao.updateProduct(id, productType, productName, productPrice,productStock);
    }
    
    /**
     * Method to delete product
     * @param id of product to be deleted
     * @return status of product deleted or not
     */
    @Override
    public Status deleteProduct(int id) {
        return baseDao.deleteProduct(id);
    }

    /**
     * method to add product into cart
     * @param productID of product to be added
     * @param productQuantity of product
     * @return status of product added to cart or not
     */
    @Override
    public Status addProductToCart(int productID, int productQuantity) {
        return baseDao.addProductToCart(productID, productQuantity);
    }

    /**
     * method to get cart items with quantity
     * @return  cart items with quantity
     */
    @Override
    public Map<Product, Integer> getCart() {
        return baseDao.getCart();
    }

    /**
     * 
     * @param productID of product to be updated
     * @param productQuantity of product 
     * @return status of cart updated or not
     */
    @Override
    public Status updateProductToCart(int productID, int productQuantity) {
        return baseDao.updateProductToCart(productID, productQuantity);
    }

    /**
     * 
     * @param productID of product to be deleted
     * @return status of product deleted from cart or not
     */
    @Override
    public Status deleteProductFromCart(int productID) {
        return baseDao.deleteProductFromCart(productID);
    }

}
