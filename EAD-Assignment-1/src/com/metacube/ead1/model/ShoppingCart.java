package com.metacube.ead1.model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart extends BaseEntity{
    
    private Map<Product,Integer> productsInCart =new HashMap<Product, Integer>();
    private double totalAmount;
    
    public ShoppingCart(){
    }
    
    public ShoppingCart(int id, Map<Product, Integer> productsInCart) {
        super(id);
        this.productsInCart = productsInCart;
    }

    // Getters and Setters Methods
    public Map<Product, Integer> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(Map<Product, Integer> productsInCart) {
        this.productsInCart = productsInCart;
    }
    
    public void addProductToCart(Product product, int productQuantity){
        productsInCart.put(product,productQuantity);        
    }
    
    public void removeProductToCart(Product product){
        productsInCart.remove(product);        
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((productsInCart == null) ? 0 : productsInCart.hashCode());
        long temp;
        temp = Double.doubleToLongBits(totalAmount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShoppingCart other = (ShoppingCart) obj;
        if (productsInCart == null) {
            if (other.productsInCart != null)
                return false;
        } else if (!productsInCart.equals(other.productsInCart))
            return false;
        if (Double.doubleToLongBits(totalAmount) != Double
                .doubleToLongBits(other.totalAmount))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ShoppingCart [ID="+ getId() +", productsInCart=" + productsInCart.toString()
                + ", totalAmount=" + totalAmount + "]";
    }


    
}
