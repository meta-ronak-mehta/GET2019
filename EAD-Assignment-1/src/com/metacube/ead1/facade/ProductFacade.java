package com.metacube.ead1.facade;

import java.util.Map;

import com.metacube.ead1.dao.ProductDao;
import com.metacube.ead1.enums.DBType;
import com.metacube.ead1.enums.Status;
import com.metacube.ead1.factory.DAOFactory;
import com.metacube.ead1.model.Product;

public class ProductFacade {

    ProductDao productDao=DAOFactory.createProductDao();

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
    public Status createProduct(DBType dbType, int productCode, String productType,String productName, double productPrice, int productStock){
         //check for product is that already in list
//        for(Map.Entry<Product,Integer> entry :productDao.getAllProduct().entrySet()){
//            if(productCode == entry.getKey().getId()){
//                return Status.DUPLICATE;
//            }
//        }
        return productDao.createProduct(productCode, productType, productName,productPrice, productStock);
    }
    
    /**
     * Method to return the list of Product and  available stock
     * @return list the list of Product and  available stock
     * 
     */
    public Map<Product,Integer> getProducts(){
        return productDao.getAllProduct();
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
    public Status updateProduct(int id, String productType,String productName, double productPrice, int productStock){
        boolean productExist=false;
        for(Map.Entry<Product,Integer> entry :productDao.getAllProduct().entrySet()){
            if(id == entry.getKey().getId()){
                productExist=true;
            }
        }
        if(productExist)
            return productDao.updateProduct(id, productType, productName, productPrice, productStock);
        return Status.NOT_FOUND;
    }
    
    /**
     * Method to delete product
     * @param id of product to be deleted
     * @return status of product deleted or not
     */
    public Status deleteProduct(int id){
        for(Map.Entry<Product,Integer> entry :productDao.getAllProduct().entrySet()){
            if(id == entry.getKey().getId()){
                return productDao.deleteProduct(id);
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
    public Status addProductToCart(int productID,int productQuantity){
        boolean productExist= false;
        // check is this product exist or not
        for(Map.Entry<Product,Integer> entry : productDao.getAllProduct().entrySet()){
            if(productID == entry.getKey().getId()){
                productExist=true;
                break;
            }
        }
        if(! productExist){
            return Status.INVALID;
        }
            //else add product to cart            
        return productDao.addProductToCart(productID, productQuantity);
    }
    
    /**
     * method to get cart items with quantity
     * @return  cart items with quantity
     */
    public Map<Product,Integer> getCartItem(){
        return productDao.getCart();
    }
    
    /**
     * 
     * @param productID of product to be updated
     * @param productQuantity of product 
     * @return status of cart updated or not
     */
    public Status updateProductToCart(int productID,int productQuantity){
        boolean productExist= false;
        // check is this product exist or not
        for(Map.Entry<Product,Integer> entry : productDao.getCart().entrySet()){
            if(productID == entry.getKey().getId()){
                productExist=true;
                break;
            }
        }
        if(productExist)
            return productDao.updateProductToCart(productID, productQuantity);
        return Status.NOT_FOUND;        
    }
    
    /**
     * 
     * @param productID of product to be deleted
     * @return status of product deleted from cart or not
     */
    public Status deleteProductFromCart(int productID){     
        boolean productExist= false;
        // check is this product exist or not
        for(Map.Entry<Product,Integer> entry : productDao.getCart().entrySet()){
            if(productID == entry.getKey().getId()){
                productExist=true;
            }
        }
        if(productExist)
            return productDao.deleteProductFromCart(productID);
        return  Status.NOT_FOUND;
    }

}
