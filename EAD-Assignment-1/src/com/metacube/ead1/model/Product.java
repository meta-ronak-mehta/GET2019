package com.metacube.ead1.model;

public class Product extends BaseEntity{

    private String productType;
    private String productName;
    private double productPrice;

    public Product(int productCode, String productType, String productName,double productPrice) {
        super(productCode);
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
    }
    public Product(){
        super();
    }

    
    // Getters and Setters Methods
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product [productCode=" + getId() + ", productType="
                + productType + ", productName=" + productName
                + ", productPrice=" + productPrice + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((productName == null) ? 0 : productName.hashCode());
        long temp;
        temp = Double.doubleToLongBits(productPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result
                + ((productType == null) ? 0 : productType.hashCode());
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
        Product other = (Product) obj;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (Double.doubleToLongBits(productPrice) != Double
                .doubleToLongBits(other.productPrice))
            return false;
        if (productType == null) {
            if (other.productType != null)
                return false;
        } else if (!productType.equals(other.productType))
            return false;
        return true;
    }
    
    
    
     

}
