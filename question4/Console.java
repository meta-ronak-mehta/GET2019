package question4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int choice = 0;
        char var = 97;
        List<Term> termList = new ArrayList<Term>();

        while (choice != 9) {
            System.out.println("1 Enter new term ");
            System.out.println("2 visualize");
            System.out.println("9 Exit");

            choice = getValidInteger();

            switch (choice) {

            case 1:
                System.out.println("coefficient (double): ");
                double coefficient = getValidDouble();
                System.out.println("Power (int): ");
                int power = getValidInteger();
                Variable variable = new Variable(var++, power);
                Term term = new Term(coefficient, variable);
                termList.add(term);
                break;
            case 2:
                MultiVariate multiVariateObject = new MultiVariate(termList);
                System.out.println(multiVariateObject.visualisedMultivariatePolynomial());
                break;
            case 9:
                choice = 9;
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
                System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                sc.nextLine();
            }
        } while (continueInput);
        return value;
    }


    /**
     * @return :an double passed by user with exception handling
     */
    public static double getValidDouble() {
        double value = 0;
        boolean continueInput = true;
        do {
            try {
                value = sc.nextDouble();
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (" + "Incorrect double: an double is required)");
                sc.nextLine();
            }
        } while (continueInput);
        return value;
    }
}
