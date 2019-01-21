import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Marksheet{
    private static final int  minMarksToPass=40;
    private int grade,studentId;
    private static int id=1;
    private static Scanner sc=new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("###.##");
    
    public Marksheet(int grd){
        grade=grd;
        studentId=id;
        id++;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        int noOfStudent;
        System.out.print("Enter no of student:\t");
        noOfStudent=getValidInteger();
        
        List <Marksheet>  studentGrades =new ArrayList<Marksheet>();
        int marks;
        for(int i=0; i < noOfStudent ;i++){
            System.out.println("enter the grades of student " + (i+1));
            marks=getValidInteger();
            Marksheet a=new Marksheet(marks);
            studentGrades.add(a);
        }
        
        int choice;
        do{
            System.out.println("1. Avg of all grade");
            System.out.println("2. Max of all grade");
            System.out.println("3. Min of all grade");
            System.out.println("4. Passed Student");
            System.out.println("9. Exit !!!");
            
            choice=getValidInteger();
            
            switch(choice){
            case 1:
                System.out.println("Avg of all grades are: "+ Marksheet.avgGrade(studentGrades));
                break;
            case 2:
                System.out.println("Max of all grades are: "+ Marksheet.maxGrade(studentGrades));
                break;
            case 3:
                System.out.println("Min of all grades are: "+ Marksheet.minGrade(studentGrades));
                break;
            case 4:
                System.out.println("List of passed Student :");
                List <Marksheet> passedStudent=Marksheet.passedStudent(studentGrades);
                for(Marksheet x: passedStudent)
                    System.out.println("Student id: "+x.getStudentId() + "\t\t"+ "Grade :"+x.getGrade());
                float percentage =(float) ((passedStudent.size()*100.0)/studentGrades.size());
                percentage = Float.valueOf(df.format(percentage));
                System.out.println("School result : "+  percentage +" %");
                break;
            case 9:
                sc.close();
                break;
            default:
                System.out.println("Enter A valid Choice!!!");
            } 
        }while(choice!=9);
    }

    
    public int getGrade(){  return grade;   }
    
    public int getStudentId(){ return studentId;    }
    
    /**
     * find average of a List
     * @param list :List of mark sheet of student whose average grade to be calculated 
     * @return result : average of the grades of list 
     * 
     */
    public static float avgGrade(List<Marksheet> list){
        float result;
        int total=0;
        
        for(Marksheet x: list){
            total += x.getGrade();
        }
        result = (float)total / list.size();
        result= Float.valueOf(df.format(result));
        return result;
    }

    /**
     * find Maximum grade  of a List
     * @param list :List of mark sheet of student
     * @return result : Maximum grade of given list 
     * 
     */
    public static int maxGrade(List<Marksheet> list){
        int result=0;
        
        for(Marksheet x: list){
            if(result < x.getGrade())
                result=x.getGrade();
        }
        return result;
    }

    /**
     * find Minimum Grade  of a List
     * @param list :List of mark sheet of student
     * @return result : Minimum grade of given list 
     * 
     */
    public static int minGrade(List<Marksheet> list){
        int result=100;
        
        for(Marksheet x: list){
            if(result > x.getGrade())
                result=x.getGrade();
        }
        return result;
    }
    
    /**
     * find List of student passed
     * @param list :List of mark sheet of student
     * @return result : List of student who are Passed 
     * 
     */
    public static List<Marksheet> passedStudent(List <Marksheet> list){
        List <Marksheet> result = new ArrayList<Marksheet>();
        
        for(Marksheet x: list)
            if(x.getGrade() >= minMarksToPass )
                result.add(x);
        return result;
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