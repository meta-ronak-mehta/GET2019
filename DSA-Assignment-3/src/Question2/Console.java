package Question2;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionhandling.MyLogFile;
import exceptionhandling.QueueException;

public class Console {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter size of priority queue ");
        int size = getValidInteger();
        PriorityQueue priorityQueue = new PriorityQueueArray(size);

        int choice = 0;
        while (choice != 9) {
            System.out.println("1 Insert");
            System.out.println("2 Remove");
            System.out.println("3 Check empty");
            System.out.println("4 Check full");
            System.out.println("9 Exit");

            choice = getValidInteger();
            switch (choice) {
            case 1:
                System.out.println("Enter job name and priority");
                int jobName = getValidInteger();
                int priority = getValidInteger();
                Job job = new Job(jobName, priority);
                try {
                    if (priorityQueue.enqueue(job))
                        System.out.println("Job Inserted");
                    else
                        System.err
                                .println("something went wrong :job not inserted into Queue");
                } catch (QueueException e) {
                    MyLogFile.writeToFile("Message:" + e.getMessage()
                            + " Time:" + new Date() + "\n");
                }
                break;
            case 2:
                try {
                    Job jobRemoved = priorityQueue.dequeue();
                    if (jobRemoved != null)
                        System.out.println("Job removed:"
                                + jobRemoved.getValue());
                    else
                        System.err
                                .println("something went wrong :job not removed into Queue");
                } catch (QueueException e) {
                    MyLogFile.writeToFile("Message:" + e.getMessage()
                            + " Time:" + new Date() + "\n");
                }
                break;
            case 3:
                System.out.println("Empty Status : " + priorityQueue.isEmpty());
                break;
            case 4:
                System.out.println("Full Status : " + priorityQueue.isFull());
                break;
            case 9:
                sc.close();
                break;
            default:
                System.out.println("Wrong Entry \n ");
                break;
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
                System.out.println("Try again. ("
                        + "Incorrect input: an integer is required)");
                sc.nextLine();
            }
        } while (continueInput);
        return value;
    }
}
