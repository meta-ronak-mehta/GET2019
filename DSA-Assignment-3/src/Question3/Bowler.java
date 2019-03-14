package Question3;


public class Bowler {

	/* Name of the bowler */
	private String name;
	/* Number of balls to be thrown by the bowler */
	private int numOfBalls;

	public Bowler(String name, int balls) {
		this.name = name;
		this.numOfBalls = balls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfBalls() {
		return numOfBalls;
	}

	public void setNumOfBalls(int numOfBalls) {
		this.numOfBalls = numOfBalls;
	}

}
