import java.util.*;


public class Cart {
	
	public static final String noSuchProductExist="NONE";
	
	public List<Product> productList =new ArrayList<Product>() ;
	
	
	public Cart(){
//		productList.add(new Product("Soap",50,12));
//		productList.add(new Product("Brush",10,7));
//		productList.add(new Product("Paste",150,2));
//		productList.add(new Product("Oil",550,5));
//		productList.add(new Product("Shampoo",120,3));
	}
	
	public void addItem(){
		Product productToBeAdded=itemList();
		if(productToBeAdded.productName==noSuchProductExist){
			System.out.println("Something went Wrong Product cant'be Added !!!");
			return;
		}
		for(Product x: productList){
			if(x.productName == productToBeAdded.productName){
				x.quantity++;
				System.out.println("Product quantity Increased by 1 Successfully!!!");
				return;
			}
		}
		productList.add(productToBeAdded);
		System.out.println("Item Added Successfully!!!");
	}
	
	public void removeItem(){
		viewCart();
		Product productToBeRemoved;
		System.out.println("Which Product you Want to Remove?");
		int productIndex=new Scanner(System.in).nextInt()-1;
		if(productIndex >= 0 && productIndex < productList.size())
			productToBeRemoved=productList.get(productIndex);
		else{
			System.out.print("Enter a Valid Choice");
			removeItem();
			return;
		}
//		Product productToBeRemoved=itemList();
		if(productToBeRemoved.productName==noSuchProductExist){
			System.out.println("Something went Wrong Product cant'be removed !!!");
			return;
		}
		for(Product x: productList){
			
			if(x.productName == productToBeRemoved.productName && x.quantity > 1){
				x.quantity--;
				System.out.println("Product quantity Reduced by 1 Successfully!!!");
				return;
			}
			else if( x.productName == productToBeRemoved.productName && x.quantity == 1 && productList.remove(productToBeRemoved) ){
				System.out.println("Product removed Successfully!!!");
				return;
			}
		}
			System.out.println("Something went Wrong Product cant'be removed !!!");
		}
	
	public void viewCart(){
		System.out.println("S.No\tProduct Name\t\tPrice\tQuantity\tTotal");
		int grandTotal=0;
		int sNo=1;
		for(Product x: productList){
			grandTotal= grandTotal+x.productPrice*x.quantity;
			System.out.println(sNo+"\t"+x.getProductName() +"\t\t\t" + x.getProductPrice() +"\t" + x.getQuantity() +"\t\t" + x.productPrice*x.quantity);
			sNo++;
		}
		System.out.println("\t\t\t\t\tGrand Total\t"+"="+grandTotal);
		
	}
	
	public Product itemList(){
		
		System.out.print("1 for Soap");
		System.out.println("\t2 for Brush");
		System.out.print("3 for Paste");
		System.out.println("\t4 for Oil");
		System.out.print("5 for Shampoo");
		System.out.println("\t9 to go Back");
		
		Scanner sc=new Scanner(System.in);
		
		while(true){
			int productNo =sc.nextInt();
			if(productNo==1)
				return new Product("Soap",50,1);
			else if(productNo==2)
				return new Product("Brush",10,1);
			else if(productNo==3)
				return new Product("Paste",150,1);
			else if(productNo==4)
				return new Product("Oil",550,1);
			else if(productNo==5)
				return new Product("Shampoo",120,1);
			else if(productNo==9)
				return new Product(noSuchProductExist,0,0);
			else
				System.out.println("Enter a Valid Choice");
			
		}
		
		
		
	}

}
