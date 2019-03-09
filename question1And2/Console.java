package question1And2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        int choice = 0;
        while (choice != 9) {
            System.out.println("1 Insertion");
            System.out.println("2 Rotate SubList");
            System.out.println("3 Make loop");
            System.out.println("4 Detect loop");
            System.out.println("5 Print List");
            choice = getValidInteger();

            switch (choice) {

            case 1:
                System.out.println("Enter Value to be inserted");
                int value = getValidInteger();
                list.insert(value);
                break;
            case 2:
                System.out.println("Enter left position: ");
                int left = getValidInteger();
                System.out.println("Enter Right Position");
                int right = getValidInteger();
                System.out.println("Enter no of steps");
                int steps = getValidInteger();
                list.clockwiseSubListRotation(left, right, steps);
                break;
            case 3:
                System.out.println("enter the postion where you want looping");
                int loopPoint = getValidInteger();
                list.makeLoop(loopPoint);
                break;
            case 4:
                boolean isLoopThere = list.detectLoop();
                if (isLoopThere) {
                    System.out.println("Loop is detected");
                } else
                    System.out.println("There no Loop detected");
                break;
            case 5:
                System.out.println(list);
                break;
            case 9:
                choice = 9;
                break;

            default:
                System.out.println("Enter a Valid choice");

            }

        }
    }

    /**
     * @return :an integer passed by user with exception handling
     */
    public static int getValidInteger() {
        int value = 0;
        Scanner sc = new Scanner(System.in);
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
        sc.close();
        return value;
    }
}
