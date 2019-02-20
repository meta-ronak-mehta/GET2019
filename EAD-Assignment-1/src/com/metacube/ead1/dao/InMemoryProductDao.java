package com.metacube.ead1.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.ead1.enums.Status;
import com.metacube.ead1.factory.DAOFactory;
import com.metacube.ead1.model.Product;
import com.metacube.ead1.model.User;

public class InMemoryProductDao implements BaseDao<Product>{

    private Map<Product,Integer> productList =new HashMap <Product, Integer>();
    private User user=DAOFactory.createUser(1, "Ram", 8941, "xyz@example.com");
    
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
        Product product = DAOFactory.createProduct(productCode, productType, productName, productPrice);
        productList.put(product,productStock);     
        return Status.INSERTED;
    }

    /**
     * Method to return the list of Product and  available stock
     * @return list the list of Product and  available stock
     * 
     */
    @Override
    public Map<Product,Integer> getAllProduct() {
        return productList;
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
        for(Map.Entry<Product,Integer> entry :productList.entrySet()){
            if(id == entry.getKey().getId()){
                entry.getKey().setProductName(productName);
                entry.getKey().setProductPrice(productPrice);
                entry.getKey().setProductType(productType); 
                entry.setValue(productStock);
                return Status.UPDATED;                
            }
        }
      return Status.INVALID;
    }
    
    /**
     * Method to delete product
     * @param id of product to be deleted
     * @return status of product deleted or not
     */
    @Override
    public Status deleteProduct(int id) {
        for(Map.Entry<Product,Integer> entry :productList.entrySet()){
            if(id == entry.getKey().getId()){
                productList.remove(entry.getKey());               
                return Status.DELETED;                
            }
        }
      return Status.NOT_FOUND;
    }
    
    /**
     * method to add product into cart
     * @param productID of product to be added
     * @param productQuantity of product
     * @return status of product added to cart or not
     */
    @Override
    public Status addProductToCart(int productID , int productQuantity){
        //iterate to every product available and then add product have that id
        for(Map.Entry<Product,Integer> entry : productList.entrySet()){
            if(productID == entry.getKey().getId()){
                user.getCart().addProductToCart(entry.getKey(), productQuantity);
                return Status.INSERTED;
            }
        }
        return Status.INVALID;
    }
    
    /**
     * method to get cart items with quantity
     * @return  cart items with quantity
     */
    @Override
    public Map<Product,Integer> getCart(){
        return user.getCart().getProductsInCart();
    }
    
    /**
     * 
     * @param productID of product to be updated
     * @param productQuantity of product 
     * @return status of cart updated or not
     */
    @Override
    public Status updateProductToCart(int productID , int productQuantity){
        // check is this product exist or not
        for(Map.Entry<Product,Integer> entry : user.getCart().getProductsInCart().entrySet()){
            if(productID == entry.getKey().getId()){
                entry.setValue(productQuantity);
                return Status.UPDATED;
            }
        }
        return Status.INVALID;       
    }
    
    /**
     * 
     * @param productID of product to be deleted
     * @return status of product deleted from cart or not
     */
    @Override
    public Status deleteProductFromCart(int productID){
        // check is this product exist or not
        for(Map.Entry<Product,Integer> entry : user.getCart().getProductsInCart().entrySet()){
            if(productID == entry.getKey().getId()){
                user.getCart().removeProductToCart(entry.getKey());
                return  Status.DELETED;
            }
        }
        return  Status.INVALID;
    }
       
}
