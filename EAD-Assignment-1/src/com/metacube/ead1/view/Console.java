package com.metacube.ead1.view;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.metacube.ead1.controller.ProductController;
import com.metacube.ead1.enums.DBType;
import com.metacube.ead1.enums.Status;
import com.metacube.ead1.model.Product;

public class Console {
    
    private static Scanner sc=new Scanner(System.in);
    
    public static void main(String aregs[]){
        int choice=0;

        Status result;
        Map<Product,Integer> listOfProduct;
        int id;
        int stock;
        int dbType;
        int quntity;
        String name;
        String type;
        double price;
        ProductController productController=new ProductController();
        
        while(choice !=9){
            showMenu();
            choice = getValidInteger();
             
            switch(choice){
            case 1:
                System.out.println("id (number):  ");
                    id=getValidInteger();
                System.out.println("name (String): ");
                    name= sc.nextLine();
                System.out.println("type (String): ");
                    type=sc.nextLine();
                System.out.println("price (number): ");
                    price=getValidDouble();
                System.out.println("stock (String): ");
                    stock=getValidInteger();
                System.out.println("select database type\n1 :MYSQL\n2 :InMemory");
                dbType=getValidDB();
                
                if(dbType == 1)
                    result = productController.createProduct(DBType.MYSQL, id, type, name,price,stock);
                else
                    result = productController.createProduct(DBType.IN_MEMORY, id, type, name,price,stock);
                System.out.println(result);
                break;
            case 2:
                listOfProduct = productController.getProducts();
                if(listOfProduct.size() > 0)
                    showProducts(listOfProduct);
                else
                    System.out.println("product list is empty");
                break;
            case 3:
                listOfProduct = productController.getProducts();
                if(listOfProduct.size() > 0){
                    showProducts(listOfProduct);
                    System.out.println("\nEnter details of product to be deleted");
                    System.out.println("id (number):  ");
                        id=getValidInteger();
                    System.out.println("name (String): ");
                        name= sc.nextLine();
                    System.out.println("type (String): ");
                        type=sc.nextLine();
                    System.out.println("price (number): ");
                        price=getValidDouble();
                    System.out.println("stock (String): ");
                        stock=getValidInteger();
                    result = productController.updateProduct(id, type, name,price,stock);
                    System.out.println(result);
                }
                else
                    System.out.println("product list is empty");
                break;
            case 4:
                listOfProduct = productController.getProducts();
                if(listOfProduct.size() > 0){
                    showProducts(listOfProduct);
                    System.out.println("product id of product to be deleted");
                    id= getValidInteger();
                    result = productController.deleteProduct(id);
                    System.out.println(result);
                }
                else
                    System.out.println("product list is empty");
                break;
            case 5:
                listOfProduct = productController.getProducts();
                if(listOfProduct.size() > 0){
                    showProducts(listOfProduct);    
                    System.out.println("product id of product to be added into cart");
                    id= getValidInteger();
                    System.out.println("Quntity of product");
                    quntity = getValidInteger();
                    result =  productController.addProductToCart(id,quntity);
                    System.out.println(result);
                }
                else
                    System.out.println("product list is empty");
                break;
            case 6:
                listOfProduct = productController.getCartItem();
                if(listOfProduct.size() > 0)
                    showProducts(listOfProduct); 
                else
                    System.out.println("Cart is empty");
                break;
            case 7:
                listOfProduct = productController.getCartItem();
                if(listOfProduct.size() > 0){
                    showProducts(listOfProduct); 
                    System.out.println("product id of product to be updated into cart");
                    id= getValidInteger();
                    System.out.println("Quntity of product");
                    quntity=getValidInteger();
                    result = productController.updateProductToCart(id,quntity);
                    System.out.println(result);
                }
                else
                    System.out.println("product list is empty");
                break;
            case 8:
                listOfProduct = productController.getCartItem();
                if(listOfProduct.size() > 0){
                    showProducts(listOfProduct); 
                    System.out.println("product id of product to be deleted from cart");
                    id= getValidInteger();
                    result = productController.deleteProductFromCart(id);
                    System.out.println(result);
                }
                else
                    System.out.println("product list is empty");
                break;
            case 9:
                System.out.println("Thank You!!!");
                break;
            default:
                System.out.println("Enter a Valid Choice");
            }
        }

    }
    
    public static  void showProducts(Map<Product,Integer> listOfProduct){
        System.out.println("Products are: ");
        for(Map.Entry<Product,Integer> entry :listOfProduct.entrySet()){
            String productString = entry.getKey().toString();
            productString += " Stock available: "+ entry.getValue().toString();
            System.out.println(productString);
        }
    }
    
    /**
     * show all available options 
     */
    public static void showMenu(){
        System.out.println("1 add new product");
        System.out.println("2 show all products");
        System.out.println("3 update product");
        System.out.println("4 delete product");
        System.out.println("5 add product to cart");
        System.out.println("6 show cart");
        System.out.println("7 update products in cart");
        System.out.println("8 remove product from cart");
        System.out.println("9 exit!!!");
    }
    
    /**
     * @return :an integer passed by user with exception handling for choice of 1 and 2
     */
    public static  int getValidDB(){
        int value=0;
        boolean continueInput=true; 
        do {
            try{
                value=sc.nextInt();
                if(value == 1 || value == 2 )
                    continueInput = false;
                else
                    System.out.println("Try again. " + "Incorrect value:1 or 2 is required)");
                }
            catch (InputMismatchException ex) {
                System.out.println("Try again. " + "Incorrect value:1 or 2 is required)");
                sc.nextLine();
                }
            }
        while(continueInput);
        return value;
    }
    
    /**
     * @return :an integer passed by user with exception handling
     *
     */
    public static  int getValidInteger(){
        int value=0;
        boolean continueInput=true; 
        do {
            try{
                value=sc.nextInt();
                continueInput = false;
                }
            catch (InputMismatchException ex) {
                System.out.println("Try again. " + "Incorrect value: an integer is required)");
                sc.nextLine();
                }
            }
        while(continueInput);
        return value;
    }
    
    /**
     * @return :a double passed by user with exception handling
     */
    public static double getValidDouble(){
        double value=0;
        boolean continueInput=true; 
        do {
            try{
                value=sc.nextInt();
                continueInput = false;
                }
            catch (InputMismatchException ex) {
                System.out.println("Try again. " + "Incorrect value: an double is required)");
                sc.nextLine();
                }
            }
        while(continueInput);
        return value;
    }

}
