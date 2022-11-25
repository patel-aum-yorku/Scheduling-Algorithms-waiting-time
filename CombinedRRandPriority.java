package asss1a;



	import java.util.Collection;
	import java.util.Iterator;
	import java.util.Queue;



	import java.util.*;
	

	class Process{
		private int pid; //process id
		private int bt;//burst time of process
		private int wt;// waiting time of the process
		private int pt;//arrival time
		private int lt;// time left for process to complete
		 
		/*
		 * Constructor for creating processes
		 * It takes in int pid, int bt(burst time) and int at(arrival time) as
		 * parameters
		 *  
		 */
		public Process(int pid, int bt, int pt) throws Exception {
			if (pid<0 || bt<0 || pt<0) { // if n is less than zero
				throw new NegativeException("value entered is negitive"); // throws NegitiveException
			}
			this.pt = pt;
			this.bt = bt;
			this.pid = pid;
			this.lt = this.bt;
			}
		
		
		 /* Methods to add and subtract waiting time*/
		 
		public void addWt(int n) {
			this.wt += n;
		}
		public void sub(int n) {
			this.lt -= n;
		}
		// Method to get wait time
		public int getWt() {
			return this.wt;
		}
		//Method to get burst time
		public int getBt() {
			return this.bt;
		}
		//Method to get Pid
		public int getPid() {
			return this.pid;
		}
		//Method to get time left
		public int getLt() {
			return this.lt;
		}
		//Method to get priority of the process
		public int getPt() {
			return this.pt;
		}
	}
	//All the exception classes are defined here
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
	class NegativeException extends Exception {  // exception for value of any input being negative

	    public NegativeException(String message) {
	        super(message);
	    }
	}
	/*
	 * Implementing ArrayQueue for processes those with same priority  and get the waiting time using 
	 * round robin scheduling
	 * 
	*/

	class ArrayQueue<E> {
		//instance variables
	 static int CAPACITY = 100;
	 private E[] data;
	 private int f = 0;
	 private int sz = 0;
	 
	 //constructors
	 public ArrayQueue() {
		 this(CAPACITY);
	 }

	public ArrayQueue(int capacity) {
		// TODO Auto-generated constructor stub
		data = ((E[]) new Object[capacity]);
	}
	//Methods

	//returns size of queue
	public int size() {return this.sz;}

	//tests whether the queue is empty
	public boolean isEmpty() {return(sz==0);}

	//inserts an element at rear of queue
	public void enqueue(E e) throws IllegalStateException {
		if(sz == data.length) throw new IllegalStateException("Queue is full");
		int avail = (f + sz) % data.length;
		data[avail] = e;
		sz++;
	}

	//returns but does not removes the first elements of the queue (null if empty)
	public E first() {
		if(isEmpty()) return null;
		return data[f];
	}

	//removes and returns the first element of the queue (null if empty)
	public E dequeue() {
		if(isEmpty()) return null;
		E answer =  data[f];
		data[f] = null;
		f = (f +1) % data.length;
		sz--;
		return answer;
	}
	}

	/*
	 * This is combination of round robin and priority scheduling when arrival time is zero,
	 * it has some n processes and time quantum q
	 */
	public class CombinedRRandPriority {
		ArrayList <Process> processes; // Array list of processes
		int q; // time quantum
		int n; // number of processes
		static int time = 0;
		/*
		 * Using array queue we can store processes. The following constructor helps to create
		 * process and stores them inside  array queue.
		 * 
		 * Note:- Arrival time is zero 
		 */
		public CombinedRRandPriority(int n,int[] Bt, int[] Pt, int q) throws Exception {
			this.n = n;
			this.q = q;
			this.processes = new ArrayList<Process>(n);
			for(int i = 0; i<n ; i++) {// creating process with the given parameters
			this.processes.add(new Process(i, Bt[i], Pt[i]));
			}
		}
		
		/*
		 * Implementing a method that will calculate the waiting time when multiple processes have same priority 
		 * using Round Robin scheduling 
		 */
		
		public double RoundRobinWt(ArrayQueue <Process> pro, int n ){
			int time = 0;// an array to hold completion times processes in round robin scheduling
			int wait = 0;
			//int start = this.time;
			boolean loop = true;
			int average = 0;
			int iterate = pro.size();
			int i = 0; 
			int stime = 0;
			while(pro.size() != 0) {
				i++;
				average +=time;
				/*
				 *  following conditions check whether the burst time is less than quantum time of process
				 *  and takes action accordingly
				 */
				if(pro.first().getLt() < this.q) {
					pro.first().sub(pro.first().getLt());
					time = pro.first().getBt();
					//this.time+=time;
				}
				else {
					pro.first().sub(q);
					time = q;
					//this.time+=time;
					
				}
				/*
				 * following conditions check whether the process is over by checking if burst time is equal to 0
				 * if its not then it puts the process at end queue other wise it removes it from the queue
				 */
				if(pro.first().getLt() != 0) {
					Process p = pro.dequeue();
					pro.enqueue(p);
				}
				else {
					pro.dequeue();
					stime += time;
					}
				if(loop) {
					wait += average;
				}
				if(i == iterate && (pro.size() != 0)) {
					time = stime;
					wait +=time;
					stime = 0;
					iterate=0;
					loop = false;
					average = 0;
				}
				
			}
			return wait;
		}
		
	//sorting the process in according to priorities
			public static Comparator<Process> pt = new Comparator<Process>() {
				public int compare(Process p1, Process p2) {
					int pt1 = p1.getPt();
					int pt2 = p2.getPt();
					return pt1 - pt2;
			}};
				
	/*
	 * This method calculates average waiting time.
	 * All processes after being sorted according to priority and for loop checks how many
	 * processes have same priority and those with same priority are processed using round robin scheduling and
	 * rest  are processed according to the priority.
	 * 		
	 */
		
		public double avgWaitingTime() {
			
		 Collections.sort(this.processes,CombinedRRandPriority.pt);
		 	int count = 0;// count of process with same priority
			int i = 0;
			
			int start = 0;// start time of the process
			double wait = 0;//waiting time
			while(i<this.processes.size()) {
				for(int k = 0; k<processes.size() ;k++ ) {// counting process with same priority
					if(processes.get(k).getPt()==i) {
						count++;
					}
				}
				
				if(count>1) {
					ArrayQueue<Process> ready = new ArrayQueue<Process>(count);
					
					for (int j = 0; j<processes.size() ; j++) {//waiting time processes with same priority is calculate by RR Scheduling
						if(processes.get(j).getPt()==i) {
							
						ready.enqueue(processes.get(j));}
					}
					start += time;
					
				//computing total waiting time
					wait += RoundRobinWt(ready, count);
					wait +=start;
					
				}
				else {//processes with unique priority are handled by this condition where burst time is substracted from time left for the process
					time += this.processes.get(i).getBt();
					wait += time - this.processes.get(i).getBt();
					
				}
				count = 0;
				i++;
			}
			//computing average waiting time
			return wait/n;
			}


	}



	
	


	
	
