import java.util.Scanner;


public class HexCalc {
	
	private static int base=16;

	public static void main(String args[]){
		
		String result="";
		int choice;
		String hexadesimalValue1,hexadesimalValue2;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter 1st the Hexadisimal Value\t");
		hexadesimalValue1=sc.nextLine();
		System.out.print("Enter 2nd the Hexadisimal Value\t");
		hexadesimalValue2=sc.nextLine();
		
		while(true){
			System.out.println("1 for addition");
			System.out.println("2 for subtraction");
			System.out.println("3 for multiplication ");
			System.out.println("4 for division ");
			System.out.println("5 for isequal");
			System.out.println("6 for isgrater");
			System.out.println("7 for isLesser");	
			System.out.println("8 for to Convert into Desimal Value");
			choice=sc.nextInt();
			
			switch(choice){
			case 1:
				result=add(hexadesimalValue1,hexadesimalValue2);
				System.out.println(hexadesimalValue1 +" + "+hexadesimalValue2 +" = " +result);
				break;
			case 2:
				result=sub(hexadesimalValue1,hexadesimalValue2);
				System.out.println(hexadesimalValue1 +" - "+hexadesimalValue2 +" = " +result);
				break;
				
			case 3:
				result=mul(hexadesimalValue1,hexadesimalValue2);
				System.out.println(hexadesimalValue1 +" * "+hexadesimalValue2 +" = " +result);
				break;
			case 4:
				result=div(hexadesimalValue1,hexadesimalValue2);
				System.out.println(hexadesimalValue1 +" / "+hexadesimalValue2 +" = " +result + " and mod is: "+mod (hexadesimalValue1,hexadesimalValue2));
				break;
			case 5:
				if(isEqual(hexadesimalValue1,hexadesimalValue2))
					System.out.println(hexadesimalValue1 +" and "+hexadesimalValue2 + " Both No's are Equal");
				else
					System.out.println(hexadesimalValue1 +" and "+hexadesimalValue2 + " Both No's are not Equal");
				break;
			case 6:
				if(isGrater(hexadesimalValue1,hexadesimalValue2))
					System.out.println(hexadesimalValue1 +" is greater than "+hexadesimalValue2);
				else
					System.out.println(hexadesimalValue1 +" is not greater than "+hexadesimalValue2);
				break;
			case 7:
				if(isLesser(hexadesimalValue1,hexadesimalValue2))
					System.out.println(hexadesimalValue1 +" is Lesser than "+hexadesimalValue2);
				else
					System.out.println(hexadesimalValue1 +" is not Lesser than "+hexadesimalValue2);
				break;
			case 8 :
				System.out.println("Desimal of " +hexadesimalValue1 +" is "+ toDesimal(hexadesimalValue1));
				System.out.println("Desimal of " +hexadesimalValue2 +" is "+ toDesimal(hexadesimalValue2));
				break;
			default:
				System.out.println("enter a valid input");
				break;
			}
		}
	}

//	Explanation with Example	
//	take last digit and multiply by base^reverseIndex   
//	1A
//	 	 0 + 10 * (16^0) = 10
//	 	10 + 1  * (16^1) = 26
//	 				   
//	  {A,B,C,D,E,f}={10,11,12,13,14,15}
//	 

	public static int toDesimal(String hexValue){
		int desiValue=0;
		int index,digitIndex=0;
		
		for(index=hexValue.length()-1 ; index >= 0 ; index--){
			if(hexValue.charAt(index) >= '0' && hexValue.charAt(index) <= '9' )
				desiValue += (hexValue.charAt(index)-48)*Math.pow(base,digitIndex);
			else if (hexValue.charAt(index) >= 'A' && hexValue.charAt(index) <= 'F') 
				desiValue += (hexValue.charAt(index) - 55)*Math.pow(base,digitIndex);;      
			digitIndex++;
		}
		return desiValue;
	}

//	 Explanation with example 
//	   26	%	16	= 10 (A)
//	  	26	/	16	= 1
//	  
	
	public static String toHexa(int desiValue){
		String hexValue="";
		String reverse="";
		
		if(desiValue==0)
			return "0";
		
		while(desiValue != 0) 
        {    
            int reminder  = 0; 
           
            reminder = desiValue % 16; 		// storing remainder in reminder variable. 
           
            if(reminder < 10)             	// check if reminder < 10 
            	hexValue += ((char)(reminder + 48)); 
            else
            	hexValue += ((char)(reminder + 55)); 
           
            desiValue = desiValue /16; 
        } 

		for(int i = hexValue. length() - 1; i >= 0; i--) {
			reverse = reverse + hexValue. charAt(i); }
		return reverse;
	}
	
	public static String add(String hexaValue1 , String hexaValue2){
		
		String hexResult;
		int desiValue1,desiValue2,desiResult;
		
		desiValue1=toDesimal(hexaValue1);
		desiValue2=toDesimal(hexaValue2);
		
		desiResult=desiValue1+desiValue2;
		
		hexResult=toHexa(desiResult);

		return hexResult;

	}

	public static String sub(String hexaValue1 , String hexaValue2){
		String hexResult="";
		int desiValue1,desiValue2,desiResult;
		
		desiValue1 = toDesimal(hexaValue1);
		desiValue2 = toDesimal(hexaValue2);
		if(desiValue1 > desiValue2)
			desiResult = desiValue1 - desiValue2;
		else{
			desiResult = desiValue2 - desiValue1;
			hexResult = "-";
		}
		hexResult=hexResult + toHexa(desiResult);
		
		return hexResult;
	}

	public static String mul(String hexaValue1 , String hexaValue2){
		
		String hexResult;
		int desiValue1,desiValue2,desiResult;
		
		desiValue1=toDesimal(hexaValue1);
		desiValue2=toDesimal(hexaValue2);
		
		desiResult = desiValue1 * desiValue2;
		
		hexResult = toHexa(desiResult);
		
		return hexResult;
	}
	
	public static String div(String hexaValue1 , String hexaValue2){
		
		String hexResult;
		int desiValue1,desiValue2,desiResult=0;
		
		desiValue1=toDesimal(hexaValue1);
		desiValue2=toDesimal(hexaValue2);
		
		if(desiValue2!=0)
			desiResult=desiValue1/desiValue2;
		else
			System.out.print("Divied by Zero : ArithmeticException occured! ");
		hexResult=toHexa(desiResult);
		
		return hexResult;
	}

	public static String mod(String hexaValue1 , String hexaValue2){
		String hexResult;
		int desiValue1,desiValue2,desiResult=0;
		
		desiValue1=toDesimal(hexaValue1);
		desiValue2=toDesimal(hexaValue2);
		
		desiResult = desiValue1 % desiValue2;
		
		hexResult = toHexa(desiResult);
		
		return hexResult;
	}

	public static boolean isEqual(String hexaValue1 , String hexaValue2){
		return (hexaValue1.equalsIgnoreCase(hexaValue2));
	}
	
//	 Explanation with example 
//	 case 1: (A1,A11) 2nd  value is big
//	 case 2: (A6,A4) length are same
//	  					A==A
//	  					6>4
//				1st value is big

	public static boolean isGrater(String hexaValue1 , String hexaValue2){
		if(hexaValue1.length() == hexaValue2.length()){					//if length are same check every char
			for(int index=0 ; index < hexaValue1.length() ; index++){
				if(hexaValue1.charAt(index) != hexaValue2.charAt(index)) 
					return (hexaValue1.charAt(index) > hexaValue2.charAt(index));
			}
		}
		else
			return (hexaValue1.length() > hexaValue2.length());
		return false;	//if both no's are equal
	}
	
	public static boolean isLesser(String hexaValue1 , String hexaValue2){
		if(hexaValue1.length() == hexaValue2.length()){					//if length are same check every char
			for(int index=0 ; index < hexaValue1.length() ; index++){
				if(hexaValue1.charAt(index) != hexaValue2.charAt(index)) 
					return (hexaValue1.charAt(index) < hexaValue2.charAt(index));
			}
		}
		else
			return (hexaValue1.length() < hexaValue2.length());
		return false;	//if both no's are equal
	}
	
}
