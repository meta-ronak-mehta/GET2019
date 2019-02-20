package com.metacube.geta2019.dao;

import java.util.Map;

import com.metacube.geta2019.enums.Status;
import com.metacube.geta2019.factory.DAOFactory;
import com.metacube.geta2019.model.Product;
import com.metacube.geta2019.model.User;

public class InMemoryProductDao implements BaseDao<Product>{

    private Map<Product,Integer> productList;
    private User user=new User(1, "Ram", 8387,"xyz@example.com");
    
    /**
     * Method create a new product
     * @return status for product added or not
     * 
     */
    @Override
    public Status createProduct(int productCode, String productType, String productName,double productPrice,int productStock) {
        Product product=DAOFactory.createProduct(productCode, productType, productName, productPrice);
        productList.put(product,productStock);     
        return Status.INSERTED;
    }

    /**
     * Method to return the list of T objects
     * @return list
     * 
     */
    @Override
    public Map<Product,Integer> getAllProduct() {
        return productList;
    }
    
    /**
     * method to update details of product
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
     *  Method to delete product
     * @return status for product deleted or not
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
    
    @Override
    public Map<Product,Integer> getCart(){
        return user.getCart().getProductsInCart();
    }
    
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
