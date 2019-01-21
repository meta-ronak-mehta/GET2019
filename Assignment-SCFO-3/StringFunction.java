import java.util.InputMismatchException;
import java.util.Scanner;


public class StringFunction {

    private static Scanner sc =new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int choice=0;
        char stringOne[];
        char stringTwo[];
        String str;
        do{
            System.out.println("\n1 Compare 2 string");
            System.out.println("2 Reverse a string");
            System.out.println("3 to Upper Case Conversion");
            System.out.println("4 to Lower Case Conversion");
            System.out.println("5 Larger Word");
            System.out.println("9 Exit!!!");
            
            choice=getValidInteger();    
            switch(choice){
                case 1:
                    System.out.println("Enter 1st String");
                    stringOne=sc.next().toCharArray();
                    System.out.println("Enter 2st String");
                    stringTwo=sc.next().toCharArray();
                    
                    if(stringCompare(stringOne,stringTwo)==1)
                        System.out.println("String Are same");
                    else
                        System.out.println("String Are Different");
                    break;
                    
                case 2:
                    System.out.println("Enter String : ");
                    stringOne=sc.next().toCharArray();
                    System.out.println("reverse of "+new String(stringOne) + " is : "+new String(stringReverse(stringOne)));
                    break;
                case 3:
                    System.out.println("Enter String : ");
                    stringOne=sc.next().toCharArray();
                    System.out.println("Old String: "+new String(stringOne) + " new String : "+new String(stringToUpperCase(stringOne)));
                    break;
                case 4:
                    System.out.println("Enter String : ");
                    stringOne=sc.next().toCharArray();
                    System.out.println("Old String: "+new String(stringOne) + " new String : "+new String(stringToLowerCase(stringOne)));
                    break;
                case 5:
                    System.out.println("Enter String : ");
                    sc.nextLine();
                    str=sc.nextLine();
                    stringOne= str.toString().toCharArray();
                    System.out.println("largest Word of String : " +new String(stringOne)+" is : " +stringLargestWord(stringOne));
                   break;
                case 9:
                    sc.close();
                    break;
                default:
                      System.out.println("Enter a Valid Choice!!!");
            }
            
        }while(choice != 9);
  
    }
    
    /**find length of string
     *
     * @param charArray Array of char whose length to be found
     * @return length of charArray
     */
    public static int stringLength(char[] charArray){
        int i=0;
        try{
            for(i=0; charArray[i]!='\0' ; i++);
        }
        catch (Exception e){                    
        return i;    
        }
        return i;
    }
    
    
     /**compare 2 String
     *
     * @param stringOne charArray 
     * @param stringTwo charArray 
     * @return result=1 if both the charArray are same else 0
     */
    public static int stringCompare(char stringOne[],char stringTwo[]){
        int result=1;
        if(stringLength(stringTwo)==stringLength(stringOne)){
            int length=stringLength(stringTwo);
            for(int i=0 ; i<length ;i++){
                if(stringOne[i] != stringTwo[i]){
                    result=0;
                    break;
                }
            }
        }
        else
            result=0;
        return result;
    }
    
    /**find Reverse of String
     *
     * @param stringOne Array of char 
     * @return stringReverse reverse of stringOne
     */
    public static char[] stringReverse(char stringOne[]){
        int len=stringLength(stringOne);
        char stringReverse[]=new char[len];
        for(int i=0; i < len ; i++){
            stringReverse[i]=stringOne[len-1-i];
        }
//        System.out.println(new String(stringReverse));
        return stringReverse;
    }

    /**find string in lower case
     *
     * @param stringOne Array of char 
     * @return stringOne  convert upper case letter to lower Case
     */
    public static char[] stringToLowerCase(char stringOne[]){
        int len=stringLength(stringOne);
        for(int i=0; i < len ; i++){
            if(stringOne[i] >= 'A' && stringOne[i] <= 'Z')
                stringOne[i] += 32;
        }
        return stringOne;
    }

     /**find string in Upper case
     *
     * @param stringOne Array of char 
     * @return stringOne convert lower case letter to upper Case
     */
    public static char[] stringToUpperCase(char stringOne[]){
        int len=stringLength(stringOne);
        for(int i=0; i < len ; i++){
            if(stringOne[i] >= 'a' && stringOne[i] <= 'z')
                stringOne[i] -= 32;
        }
        return stringOne;
    }
        
    /**find largest Word
     *
     * @param stringOne Array of char containing no of words
     * @return largestWord of given words
     *      if two words length are same return last word
     */
    public static String stringLargestWord(char stringOne[]){
        String largestWord;
        int length=stringLength(stringOne);
        char splitString[][]=new char[length][length];
        int newWord=0,j=0;
        
        for(int i=0 ; i<length ;i++){
            if(stringOne[i]==' '){
                newWord++;
                j=0;
            }
            else{
                splitString[newWord][j]=stringOne[i]; 
                j++;
            }
        }
        largestWord = new String(splitString[0]);
        int largestLength =stringLength(splitString[0]);

        for(int i=1 ; i < stringLength(splitString[i]) ;i++){
            if(stringLength(splitString[i]) >= largestLength)
                largestWord= new String(splitString[i]);
        }
        return largestWord;
    }
    
    /**
     * @return :an integer passed by user with exception handling
     */
    public static int getValidInteger(){
        int value=0;
        boolean continueInput=true; 
        do {
            try{
                value=sc.nextInt();
                continueInput = false;
                }
            catch (InputMismatchException ex) {
                System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                sc.nextLine();
                }
            }
        while(continueInput);
        return value;
    }

}
