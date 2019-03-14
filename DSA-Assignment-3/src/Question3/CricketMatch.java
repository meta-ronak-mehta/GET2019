package Question3;

import java.util.ArrayList;
import java.util.List;

public class CricketMatch {

    private List<Bowler> bowlersList = new ArrayList<Bowler>();
    private List<Bowler> bowlerOrder = new ArrayList<Bowler>();

    /**
     * Constructor to initialise values
     * 
     * @param numOfBallsToBePlayed
     *            , number of balls to be played by the player
     * @param numOfBowlers
     *            , total number of the bowlers
     */
    public CricketMatch() {

    }

    /**
     * Method to add bowlers to the bowlersList
     * 
     * @param bowlerobject
     *            consisting of bowler's details
     */
    public void addBowler(Bowler bowler) {
        this.bowlersList.add(bowler);
    }

    /**
     * Method to make bowlers order so as to win the match
     * 
     * @return the ordered list of the bowlers
     */
    public List<Bowler> chooseBowler() {

        int totalBalls = totalBalls();
        int turn;

        while (totalBalls != 0) {
            turn = maxBalls();
            Bowler bowler = bowlersList.get(turn);
            // add first bowler directly
            if (bowlerOrder.size() == 0) {
                bowlerOrder.add(new Bowler(bowler.getName(), 1));
            } else {
                int previousIndex = bowlerOrder.size() - 1;
                Bowler previousBowler = bowlerOrder.get(previousIndex);
                // if the previous bowler is same with max balls left
                if (previousBowler.getName().equals(bowler.getName())) {
                    int ballsPlayed = bowlerOrder.get(previousIndex)
                            .getNumOfBalls();
                    bowlerOrder.get(previousIndex).setNumOfBalls(
                            ballsPlayed + 1);
                } else {
                    bowlerOrder.add(new Bowler(bowler.getName(), 1));
                }
            }
            bowler.setNumOfBalls(bowler.getNumOfBalls() - 1);
            totalBalls--;
        }
        return bowlerOrder;
    }

    /**
     * Method to find the total sum of the balls of all the bowlers
     * 
     * @return totalBalls
     */
    public int totalBalls() {
        int totalBalls = 0;
        for (Bowler bowler : bowlersList) {
            totalBalls += bowler.getNumOfBalls();
        }
        return totalBalls;
    }

    /**
     * Helper method to find the index of the bowler who has maximum balls left
     * to bowl
     * 
     * @return index of the bowler
     */
    private int maxBalls() {
        int max = 0;
        int index = 0;
        int count = 0;
        for (Bowler bowler : bowlersList) {
            if (max < bowler.getNumOfBalls()) {
                max = bowler.getNumOfBalls();
                index = count;
            }
            count++;
        }
        return index;
    }

}
