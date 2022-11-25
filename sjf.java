import java.util.Scanner;
import java.util.Date;

public class sjf {


	private int n; // Variable for length of array
	private int Arrival_Time []; // array of Arrival Time
	private int Burst_Time[]; // array for Burst Time
	private int copyBt[]; // copy of array of burst time
	private int finish[]; // array for if each process if its finished its a 1 if it incomplete its 0
	private int Completion_Time[]; // array for the completion time
	private int TurnA_Time[]; // array for the turn around time


	public sjf() { // Default constructor

	}

	public sjf(int[] arrayAt , int[] arrayBt, int n) throws Exception { // constructor
		
		if (n < 0) { // if n is less than zero
			throw new NegativeException("n value is negitive"); // throws NegitiveException
		}
		if (arrayAt.length != arrayBt.length) { // if the array lengths don't match 
			throw new NotEqualArrayLengthException("Arrays are of different lengths"); // throws NotEqualArrayLengthException
		}
		if (n != arrayAt.length && n != arrayBt.length) { // if the n value doesn't match array lengths 
			throw new LengthNotMatchException("n value dosen't match array length"); // throw LengthNotMatchException
		}
		
		this.n = n; // initializes variable n
		this.Arrival_Time = new int[n]; // makes the array of length n 
		this.Burst_Time = new int[n]; // makes the array of length n 
		this.copyBt = new int[n]; // makes the array of length n 
		this.finish = new int[n]; // makes the array of length n 
		this.Completion_Time = new int[n]; // makes the array of length n 
		this.TurnA_Time = new int[n]; // makes the array of length n 


		for(int i = 0; i< n;i++) { // for loop to copy the arrayAt and arrayBt and save it to array Arrival_Time and Burst_Time

			if(arrayBt[i] < 0 || arrayAt[i] < 0) {
				throw new NegativeArrayInputException("Array inputs are negitive");
			}
			this.Arrival_Time[i] = arrayAt[i]; // saves arrayAt at index i to array Arrival_Time at index i
			this.Burst_Time[i] = arrayBt[i]; // saves arrayBt at index i to array Burst_Time at index i
			this.copyBt[i] = this.Burst_Time[i]; // saves a copy of Burst_Time array at index i to array copyBt at index i
			this.finish[i] = 0; // sets the value for each index of i in array finish to 0 if it not being complete
		}

	}

	public double getAvwait() { // method to get average waiting time

		int start = 0; // start time
		int total = 0; // total
		double avgwt=0; // Average waiting time


		while(true){ // while loop 
			
			int min = 5000; // number of time intervals in the schedule or Gantt chart;
			int c = n; // comt
			
			if (total==n) // if total equals to n 
				break; // break out of the while loop

			for (int i=0;i<n;i++) // for loop runs n times
			{
				if ((Arrival_Time[i]<=start) && (finish[i]==0) && (Burst_Time[i]<min)) // if the arrival time is less or equal to start time 
				{                                            //and if the burst time is the shortest and if it is incomplete in array finish
					min = Burst_Time[i]; // makes the min value to lowest burst time
					c=i; // changes c to index i 
				}
			}

			if (c==n) // if no arrival time starts at time 0
				start++; // Increase the start time
			else
			{
				Burst_Time[c]--; // burst time at index c decrease by 1
				start++; // start time increase by 1
				if (Burst_Time[c] == 0) // if burst time for index c reaches 0 
				{
					Completion_Time[c] = start; // make the value for completion time array at index c to start time
					finish[c] = 1; // change the value for finished array to 1 because it has been completed
					total++; // Increase total by 1
				}
			}
		}

		for(int i=0 ;i<n; i++) // for loop runs n times
		{
			TurnA_Time[i] = Completion_Time[i] - Arrival_Time[i]; // calculate the turn around time for each index by completion time - arrival time
			avgwt+= TurnA_Time[i] - copyBt[i]; // calculate total waiting time by adding the waiting time for each index by turn around time - burst time
		}

		return avgwt/n; // returning average waiting time by dividing the total waiting time by the number of processes 
	}
	
//	Define the Exception classes here
	class NegativeArrayInputException extends LengthNotMatchException { // exception for array input being negative

	    public NegativeArrayInputException(String message) {
	        super(message);
	    }
	}
	class LengthNotMatchException extends NotEqualArrayLengthException { // exception for array length not matching n value

	    public LengthNotMatchException(String message) {
	        super(message);
	    }
	}
	class NotEqualArrayLengthException extends NegativeException { // exception for array lengths not matching 

	    public NotEqualArrayLengthException(String message) {
	        super(message);
	    }
	}
	class NegativeException extends Exception {  // exception for n being negative

	    public NegativeException(String message) {
	        super(message);
	    }
	}
	
	
	
	
	
	
	

	public static void main(String[] args) throws Exception {

		int n = 4;

		int[] array1 = new int[n];
		int[] array2 = new int[n];

		array1[0] = 0;
		array1[1] = 1;
		array1[2] = 2;
		array1[3] = 3;

		array2[0] = 8;
		array2[1] = 4;
		array2[2] = 9;
		array2[3] = 5;


		sjf sjf = new sjf(array1, array2, n);
		double avwt = sjf.getAvwait();

		System.out.print("the average waiting time is " + avwt);


	}

}

