import java.util.InputMismatchException;
import java.util.Scanner;


public class Area {
    
    private static double area;
    private static Scanner sc =new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        

        int choice;
        Double arg1,arg2;
        do{
            System.out.println("1. Area of Triangle");
            System.out.println("2. Area of Rectangle");
            System.out.println("3. Area of Square");
            System.out.println("4. Area of Circle");
            System.out.println("9. Exit !!!");
            
            choice=getValidInteger();
            
            switch(choice){
            case 1:
                System.out.println("Enter Width and height of Triangle ");
                arg1=getValidDouble();
                arg2=getValidDouble();
                area=areaOfTriangle(arg1,arg2);
                break;
            case 2:
                System.out.println("Enter Width and height of Rectangle ");
                arg1=getValidDouble();
                arg2=getValidDouble();
                area=areaOfRectangle(arg1,arg2);
                break;
            case 3:
                System.out.println("Enter Width of Square ");
                arg1=getValidDouble();
                area=areaOfSquare(arg1);
                break;
            case 4:
                System.out.println("Enter radius of Circle ");
                arg1=getValidDouble();
                area=areaOfCircle(arg1);
                 break;
            case 9:
                sc.close();
                break;
            default:
                System.out.println("Enter A valid Choice!!!");
            } 
            System.out.println("area = "+ area);
        }while(choice!=9);
    }

    
    /**find the area of a Triangle
     * @param width  width of Triangle in double
     * @param height height of Triangle in double
     * @return area of Triangle
     */
    public static double areaOfTriangle(Double width ,double height ){
        area= (0.5) * width * height; 
        return area;
    }
    
    /**find the area of a Rectangle
     * @param width  width of Rectangle in double
     * @param height height of Rectangle in double
     * @return area of Rectangle
     */
    public static double areaOfRectangle(Double width ,double height ){
        area=width * height; 
        return area;
    }
    
    /**find the area of a Square
     * @param width  width of Square in double
     * @return area of Square
     */
    public static double areaOfSquare(Double width){
        area= width * width; 
        return area;
    }
    
    /**find the area of a Circle
     * @param radius  radius of Circle in double
     * @return area of Circle
     */
    public static double areaOfCircle(Double radius ){
        area= Math.PI * radius  *radius ; 
        return area;
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
    
    /**
     * @return :an Double passed by user with exception handling
     */
    public static Double getValidDouble(){
        Double value=0.0;
        boolean continueInput=true; 
        do {
            try{
                value=sc.nextDouble();
                continueInput = false;
                }
            catch (InputMismatchException ex) {
                System.out.println("Try again. (" + "Incorrect input: an Double (real number) is required)");
                sc.nextLine();
                }
            }
        while(continueInput);
        return value;
    }
}

