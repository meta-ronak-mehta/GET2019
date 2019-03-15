package question1;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int choice = 0;
        EmployeeCollection employeeCollection = new EmployeeCollection();
        while (choice != 9) {
            System.out.println("1 Add Employee");
            System.out.println("2 Sort Employee by ID");
            System.out.println("3 Sort Employee by Name");
            System.out.println("9 Exit!!!");
            choice = getValidInteger();
            switch (choice) {

            case 1:
                System.out.println("Id: ");
                int id = getValidInteger();
                System.out.println("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("Address: ");
                String address = sc.nextLine();
                if(employeeCollection.addEmployee(id, name, address))
                    System.out.println("Employee added!!!");
                else
                    System.out.println("Employee not Added!!!");
                break;
            case 2:
                List<Employee> employeeList = employeeCollection.sortById();
                for (Employee emp : employeeList) {
                    System.out.println(emp);
                }
                break;
            case 3:
                List<Employee> employeeListSorted = employeeCollection.sortByName();
                for (Employee emp : employeeListSorted) {
                    System.out.println(emp);
                }
                break;
            case 9:
                sc.close();
                break;
            default:
                System.out.println("Enter a Valid Choice");
            }

        }

    }

    /**
     * @return :an integer passed by user with exception handling
     */
    public static int getValidInteger() {
        int value = 0;
        boolean continueInput = true;
        do {
            try {
                value = sc.nextInt();
                continueInput = false;
            } catch (InputMismatchException ex) {
                MyLogFile.writeToFile("Invalid Inpput in Employee console at: " + new Date());
                System.out.println("Try again. " + "Incorrect input: an integer is required)");
                sc.nextLine();
            }
        } while (continueInput);
        return value;
    }
}
