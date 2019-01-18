import java.util.*;


public class JobScheduler {
	
	private static int runingTime=0;
	
	public static void main(String args[]){
		int noOfProcess=0;
		System.out.print("No of Process:");
		Scanner sc=new Scanner(System.in);
		
		boolean continueInput=true;	
		do {
	        try{
	        	noOfProcess=sc.nextInt();
	        	continueInput = false;
	        }
	        catch (InputMismatchException ex) {
	            System.out.println("Try again. (" + "Incorrect input: an integer is required)");
	            sc.nextLine();
	            }
	        }
		while(continueInput);
		
		List<Process> jobs =new ArrayList<Process>() ;
		for(int i=0 ; i < noOfProcess ; ){
			
			continueInput=true;
			do {
		        try{
					System.out.print("enter arrival time and burst time for process "+ ++i);
					jobs.add(new Process(sc.nextInt(),sc.nextInt()));	
		        	continueInput = false;
		        }
		        catch (InputMismatchException ex) {
		            System.out.println("Try again. (" + "Incorrect input: an integer is required)");
		            sc.nextLine();
		            }
		        }
			while(continueInput);
		}
		
		Schedule(jobs);
		
		System.out.println("S No.:\t\tAT\t\tBT\t\tCT\t\tWT\t\tTAT");
		int sNo=1,totalWaitingTime=0,maxWaitingTime=0;
		
		for(Process x: jobs){
			System.out.println(sNo++ + " \t\t"+ x.getArrivalTime() +"\t\t"+ x.getBurstTime() +"\t\t"+ x.getCompletionTime() +"\t\t"+ x.getWaitingTime() +"\t\t"+ x.getTurnAroundTime());
			totalWaitingTime += x.getWaitingTime();
			
			if(maxWaitingTime < x.getWaitingTime())
				maxWaitingTime = x.getWaitingTime();
		}
		System.out.println("Avg Waiting Time :" + totalWaitingTime/jobs.size());
		System.out.println("Max Waiting Time :" + maxWaitingTime);
		sc.close();
	}
	
	
//		running time is the next available time when the last process free the processor
//	   
//	   if new process arrives after the completion of previous last process
//	  			waiting time = 0
//	  			next running time = arrive time + burst time of new process
//	  			
//	  else if the other process is running when the new process arrived 
//	  			waiting time = difference b/w completion time of previous process and the arrival time of current process
//	  			running time = running time + burst time of new process
//	  
//	  	turn around time = completion time -arrival time
//	  completion time = time when the process complete it's execution
	  

			
	public static void Schedule(List<Process> jobs){
		for(Process x: jobs){			
			if(runingTime > x.getArrivalTime()){
				x.setWaitingTime (runingTime- x.getArrivalTime());
				runingTime += x.getBurstTime();
			}
			else{
				runingTime = x.getBurstTime() + x.getArrivalTime();
				x.setWaitingTime (0);
			}
			
			x.setCompletionTime(runingTime);
			x.setTurnAroundTime( x.getCompletionTime() - x.getArrivalTime());
			
		}
		
	}

}
