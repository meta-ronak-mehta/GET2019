package Question3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        CricketMatch cricketMatch;

        System.out.println("Num Of Balls To Be Played: ");
        int numOfBallsToBePlayed = getValidPositiveInteger();
        System.out.println("Num Of Bowlers: ");
        int numOfBowlers = getValidPositiveInteger();
        cricketMatch = new CricketMatch();
        System.out.println("Enter the name and balls left of a bowler");
        // add bowlers
        for (int i = 0; i < numOfBowlers; i++) {
            System.out.println("Name of bolwer " + (i + 1) + ":");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Num of balls left of bowler " + (i + 1) + ":");
            int ballsLeft = getValidPositiveInteger();
            Bowler bowler = new Bowler(name, ballsLeft);
            cricketMatch.addBowler(bowler);
        }
        int numOfBallsLeftFromBowlers = cricketMatch.totalBalls();
        // if balls left from bowler side is lesser then to be played 
        if (numOfBallsLeftFromBowlers < numOfBallsToBePlayed) {
            System.out
                    .println("Number of balls to be thrown is less than number of balls to be played by the player");
        } else {
            List<Bowler> bowlingOrder = cricketMatch.chooseBowler();
            for (Bowler bowler : bowlingOrder)
                System.out.println(bowler.getName() + " "
                        + bowler.getNumOfBalls());
        }
    }

    /**
     * @return :an integer passed by user with exception handling
     */
    public static int getValidPositiveInteger() {
        int value = 0;
        boolean continueInput = true;
        do {
            try {
                value = sc.nextInt();
                if (value <= 0)
                    throw new InputMismatchException();
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. "
                        + "Incorrect input: an positive integer is required)");
                sc.nextLine();
            }
        } while (continueInput);
        return value;
    }
}
