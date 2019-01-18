
public class Process {

	private int arrivalTime,burstTime,completionTime,waitingTime,turnAroundTime;
	
	public Process(int arrival, int burst ){
		arrivalTime=arrival;
		burstTime=burst;		
	}
	
	public int getWaitingTime(){	return waitingTime;	}
	public int getArrivalTime(){	return arrivalTime;	}
	public int getBurstTime()  {	return burstTime;	}
	public int getCompletionTime(){	return completionTime;	}
	public int getTurnAroundTime(){	return turnAroundTime;	}
	
	public void  setWaitingTime(int time) {
		waitingTime=time;
	}
	public void  setTurnAroundTime(int time) {
		turnAroundTime=time;
	}
	public void  setCompletionTime(int time) {
		completionTime=time;
	}
	
}
