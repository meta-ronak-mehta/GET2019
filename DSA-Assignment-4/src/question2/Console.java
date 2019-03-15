package question2;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import question1.MyLogFile;

public class Console {

    private static Scanner sc = new Scanner(System.in);
    private static UniqueCharacters uniqueCharacters = new UniqueCharacters();

    public static void main(String args[]) {
        boolean choice = true;
        while (choice) {
            System.out.println("Enter String to get no of unique Char: ");
            String inputString = sc.nextLine();
            int noOfuniqueChar = uniqueCharacters.countUniqueCharacters(inputString);
            System.out.println(inputString +" has "+ noOfuniqueChar);
            
            System.out.println("Enter more String (true/false): ");
            choice = getValidBoolean();
            sc.nextLine();
        }
        sc.close();
    }
    
    /**
     * @return :an input passed by user with exception handling
     */
    public static boolean getValidBoolean() {
        boolean value = false;
        boolean continueInput = true;
        do {
            try {
                value = sc.nextBoolean();
                continueInput = false;
            } catch (InputMismatchException ex) {
                MyLogFile.writeToFile("Invalid Inpput in UniqueCharater console at: " + new Date());
                System.out.println("Try again. " + "Incorrect input: an boolean is required)");
                sc.nextLine();
            }
        } while (continueInput);
        return value;
    }
}
