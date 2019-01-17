import java.util.*;
public class User {
	
	public String userName;
	public static int mobileNo;
	public static Cart userCart;
	
	
	public User(){

	}
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Your Name");
		String userName=sc.nextLine();		
		System.out.println("Please Enter Your Mobile number");
	   
		boolean continueInput=true;
		do {
	        try{
	        	mobileNo = sc.nextInt();
	        	continueInput = false;
	        }
	        catch (InputMismatchException ex) {
	            System.out.println("Try again. (" + "Incorrect input: an integer is required)");
	            sc.nextLine();
	            }
	        }while(continueInput);
		
		User.userCart=new Cart();
	    int option=0;
	    do{ 
	    	System.out.println("1 for Add item");
	 		System.out.println("2 for Remove item");
	 		System.out.println("3 to View Cart");
	 		System.out.println("4 for Billing");
	 		System.out.println("9 Exit!!!");
	 		continueInput = true;
	 		do {
		        try{
		        	option= sc.nextInt();
		        	continueInput = false;
		        }
		        catch (InputMismatchException ex) {
		            System.out.println("Try again. (" + "Incorrect input: an integer is required)");
		            sc.nextLine();
		            }
		        }while(continueInput);
	 		
	 		
	 		
	 		if(option==1)
	    		 userCart.addItem();
	    	 else if(option==2){
//	    		 userCart.viewCart();
	    		 userCart.removeItem();
	    	 }
	    	 else if(option==3)
	    		 userCart.viewCart();
	    	 else if(option==4){
	    		 System.out.println("\tBill No. =221 \t\t Date:"+ new java.util.Date());
	    		 System.out.println("\tCustomer Name: "+userName+ "\n\tMobile No= "+ mobileNo+"\n"); 
	    		 userCart.viewCart();
	    		 option=9;
	    	 }
	    	 else if(option==9)
	    		 option=0;
	    	 else
	    		 System.out.println("Enter A valid Choice!!!");
	    }
	    while(option!=9);
	    
	    
	    System.out.println("Thank You For Shopping With Us!!!");
	}
}
