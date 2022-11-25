package ass1;

import static org.junit.Assert.*;
import ass1.sjfc;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_output {

	
	/*  In test 1 we input two arrays of same size and calculate the average time by calling the getAvwait method
	 *  and then we check whether the expected output and the output received by calling the method are equal or not
	 *   using assertEquals. If the arrays are not equal in length it will throw an exception.    
	 */
	@Test
	public void test1() throws Exception {
		int n=3;
		int[] array1 = new int[n];
		int[] array2 = new int[n];

		array1[0] = 2;  //initializing array
		array1[1] = 2;  //initializing array
		array1[2] = 1;  //initializing array

		array2[0] = 5;  //initializing array
		array2[1] = 3;  //initializing array
		array2[2] = 7;  //initializing array
		
		sjfc sjf = new sjfc(array1, array2, n);
		double avwt = sjf.getAvwait();  // calling the getAvwait method to calculate (the average time 
		
		assertEquals(3.66, avwt, 0.01);
	}
	
	
	
	/*  In test 2 we check if the arrays have the same size or not. If the arrays are not equal in length it will throw an exception */
	@Test
	public void test2() throws Exception {
		int n=3;
		int[] array1 = new int[4];
		int[] array2 = new int[n];

		array1[0] = 2;   //initializing array 
		array1[1] = 2;  //initializing array
		array1[2] = 1;  //initializing array
		array1[3] = 3;  //initializing array

		array2[0] = 5;  //initializing array
		array2[1] = 3;  //initializing array
		array2[2] = 7;  //initializing array
		
		sjfc sjf ;
		try {
			sjf= new sjfc(array1, array2, n);
			fail();
			double avwt = sjf.getAvwait();  // calling the getAvwait method to calculate the average time 
		}
			catch(Exception e) {
				assertEquals("Arrays are of different lengths", e.getMessage());
			}
		
		
	}
		
		
	
	@Test
	public void test3() throws Exception {
		int n=4;
		int[] array1 = new int[3];
		int[] array2 = new int[3];

		array1[0] = 2;  //initializing array
		array1[1] = 2;  //initializing array
		array1[2] = 1;  //initializing array
 
		array2[0] = 5;  //initializing array
		array2[1] = 3;  //initializing array
		array2[2] = 7;  //initializing array
		
		sjfc sjf;
		
		try {
			sjf= new sjfc(array1, array2, n);
			
			fail();
			
			double avwt = sjf.getAvwait();  // calling the getAvwait method to calculate the average time 
			
		}
			catch(Exception e) {
				assertEquals("n value doesn't match array length", e.getMessage());
			}
	}
	
	/*  In test 5 we input two arrays of same size and a negative integer n and try to calculate the average time by calling the getAvwait method
	 *  Since the integer n is negative, it throws NegativeException.    
	 */
	@Test
	public void test4() throws Exception {
		int n=-1;
		int[] array1 = new int[3];
		int[] array2 = new int[3];

		array1[0] = 2;  //initializing array
		array1[1] = 2;  //initializing array
		array1[2] = 1;  //initializing array
		

		array2[0] = 5;  //initializing array
		array2[1] = 3;  //initializing array
		array2[2] = 7;  //initializing array
		
		sjfc sjf;
		try {
			sjf= new sjfc(array1, array2, n);
			
			fail();
			//double avwt = sjf.getAvwait(); // calling the getAvwait method to calculate the average time 
		
		} catch(Exception e) {
			
		 assertEquals("n value is negative", e.getMessage());
		
		}
	
		
		
		

	}
	
	/*  In test 5 we input two arrays of same size (just like the first test case but with different inputs) and calculate the average time by calling the getAvwait method
	 *  and then we check whether the expected output and the output received by calling the method are equal or not
	 *   using assertEquals. If the arrays are not equal in length it will throw an exception.    
	 */
	
	
	@Test
	public void test5() throws Exception {
		int n=3;
		int[] array1 = new int[n];
		int[] array2 = new int[n];

		array1[0] = 4;  //initializing array
		array1[1] = 7;  //initializing array
		array1[2] = 5;  //initializing array

		array2[0] = 3;  //initializing array
		array2[1] = 2;  //initializing array
		array2[2] = 1;  //initializing array
		
		sjfc sjf = new sjfc(array1, array2, n);
		double avwt = sjf.getAvwait();  // calling the getAvwait method to calculate the average time 
		
		assertEquals(0.6666666666666666, avwt, 0.01);
	}
	
	@Test
	public void test6() {
		int[] btimes = {24, 3, 3};  
		int n  = 3;
		int quantum = 4;
		RoundRobin r = new RoundRobin(n, btimes, quantum);
		assertEquals(5.66, r.averageWaitingTime(), 0.01);
	}
	
	/*  In test 2 we take one array, an integer n which stores the length of array.
	 *  we call the method .averageWaitingTime to find the average waiting time*/
	
	@Test
	public void test7() {
		int[] btimes = {10, 5};
		int n  = 2;
		int quantum = 15;
		RoundRobin r = new RoundRobin(n, btimes, quantum);
		assertEquals(5.00, r.averageWaitingTime(), 0.01);
		
	}
	
	/*  In test 3 we take one array, an integer n which stores the length of array.
	 *  we call the method .averageWaitingTime to find the average waiting time*/
	
	@Test
	public void test8() {
		int[] btimes = {5, 10};
		int n  = 2;
		int quantum = 15;
		RoundRobin r = new RoundRobin(n, btimes, quantum);
		assertEquals(2.50, r.averageWaitingTime(), 0.01);
	}
	
	
}
