package com.metacube.geta2019.facade;

import java.util.Map;

import com.metacube.geta2019.dao.BaseDao;
import com.metacube.geta2019.dao.ProductDao;
import com.metacube.geta2019.enums.DBType;
import com.metacube.geta2019.enums.Status;
import com.metacube.geta2019.model.Product;

public class ProductFacade {

    ProductDao productDao;
    
    public Status createProduct(DBType dbType, int productCode, String productType,String productName, double productPrice, int productStock){
        // check for product is that already in list
        productDao = new ProductDao(dbType); 
        for(Map.Entry<Product,Integer> entry :productDao.getAllProduct().entrySet()){
            if(productCode == entry.getKey().getId()){
                return Status.DUPLICATE;
            }
        }
        return productDao.createProduct(productCode, productType, productName,productPrice, productStock);
    }
    
    public Map<Product,Integer> getProducts(){
        return productDao.getAllProduct();
    }
    
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
    
    public Status deleteProduct(int id){
        boolean productExist=false;
        for(Map.Entry<Product,Integer> entry :productDao.getAllProduct().entrySet()){
            if(id == entry.getKey().getId()){
                productExist=true;
            }
        }
        if(productExist)
            return productDao.deleteProduct(id);
        return Status.NOT_FOUND;
    }
    
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
        else
          //if product is already in cart
            for(Map.Entry<Product,Integer> entry : productDao.getCart().entrySet()){
                if(productID == entry.getKey().getId())
                    return Status.DUPLICATE;
            }
            //else add product to cart            
        return productDao.addProductToCart(productID, productQuantity);
    }
    
    public Map<Product,Integer> getCartItem(){
        return productDao.getCart();
    }
    
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
