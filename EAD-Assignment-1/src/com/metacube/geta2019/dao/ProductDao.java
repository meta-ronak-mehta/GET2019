package com.metacube.geta2019.dao;

import java.util.Map;

import com.metacube.geta2019.enums.DBType;
import com.metacube.geta2019.enums.Status;
import com.metacube.geta2019.model.Product;

public class ProductDao implements BaseDao<Product>{
    
    private BaseDao<Product> baseDao;
    
    public ProductDao(DBType dbtype) {
        if(dbtype ==DBType.IN_MEMORY)
            baseDao=new InMemoryProductDao();
        else
            baseDao=new MySQLProductDao();            
    }


    /**
     * Method create a new product
     * @return status for product added or not
     * 
     */
    @Override
    public Status createProduct(int productCode, String productType, String productName,double productPrice,int productStock) {
         return baseDao.createProduct(productCode, productType, productName, productPrice,productStock);
    }


    /**
     * Method to return the list of T objects
     * @return list
     * 
     */
    @Override
    public Map<Product,Integer> getAllProduct() {
        return baseDao.getAllProduct();
    }
    
    /**
     * Method to update details of product
     * @return status for product updated or not
     */
    @Override
    public Status updateProduct(int id, String productType, String productName,double productPrice,int productStock) {
        return baseDao.updateProduct(id, productType, productName, productPrice,productStock);
    }
    
    /**
     * Method to delete product
     * @return status for product deleted or not
     */
    @Override
    public Status deleteProduct(int id) {
        return baseDao.deleteProduct(id);
    }


    @Override
    public Status addProductToCart(int productID, int productQuantity) {
        return baseDao.addProductToCart(productID, productQuantity);
    }


    @Override
    public Map<Product, Integer> getCart() {
        return baseDao.getCart();
    }


    @Override
    public Status updateProductToCart(int productID, int productQuantity) {
        return baseDao.updateProductToCart(productID, productQuantity);
    }


    @Override
    public Status deleteProductFromCart(int productID) {
        return baseDao.deleteProductFromCart(productID);
    }
}
