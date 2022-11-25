package ass1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_outputRR {

	
	
	
//	
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}

	

	/*  In test 1 we take one array, an integer n which stores the length of array.
	 *  we call the method .averageWaitingTime to find the average waiting time*/
	
	@Test
	public void test1() {
		int[] btimes = {24, 3, 3};  
		int n  = 3;
		int quantum = 4;
		RoundRobin r = new RoundRobin(n, btimes, quantum);
		assertEquals(5.66, r.averageWaitingTime(), 0.01);
	}
	
	/*  In test 2 we take one array, an integer n which stores the length of array.
	 *  we call the method .averageWaitingTime to find the average waiting time*/
	
	@Test
	public void test2() {
		int[] btimes = {10, 5};
		int n  = 2;
		int quantum = 15;
		RoundRobin r = new RoundRobin(n, btimes, quantum);
		assertEquals(5.00, r.averageWaitingTime(), 0.01);
		
	}
	
	/*  In test 3 we take one array, an integer n which stores the length of array.
	 *  we call the method .averageWaitingTime to find the average waiting time*/
	
	@Test
	public void test3() {
		int[] btimes = {5, 10};
		int n  = 2;
		int quantum = 15;
		RoundRobin r = new RoundRobin(n, btimes, quantum);
		assertEquals(2.50, r.averageWaitingTime(), 0.01);
	}
	
	


}
