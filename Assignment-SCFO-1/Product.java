
public class Product {
	
	public String productName;
	public int productPrice;
	public int quantity=0;
	
	public Product(String aName,int aPrice ,int aQunatity){
		productName=aName;
		productPrice=aPrice;
		quantity=aQunatity;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public int getProductPrice(){
		return productPrice;
	}
	
	public int getQuantity(){
		return quantity;
	}
	

}
