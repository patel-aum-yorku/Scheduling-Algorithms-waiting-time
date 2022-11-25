package asss1a;

import static org.junit.Assert.*;
import asss1a.CombinedRRandPriority;

import org.junit.Test;

public class Test_output_CCandP {

	
	


	@Test
	public void test1() throws Exception {
		int n =3;
		int quantum = 4;
		int BT[]= {5,15,17};
		int PT[]= {3,1,2};
		CombinedRRandPriority r=new CombinedRRandPriority(n, BT, PT, quantum);
		
	
		double avgwt=r.avgWaitingTime();
		assertEquals(15.6666666666, avgwt, 0.01);
		
	}
		
	
	
	@Test
	public void test2() throws Exception {
		int n =4;
		int quantum = 4;
		int BT[]= {5,9,10,6};
		int PT[]= {3,1,2,4};
		CombinedRRandPriority r=new CombinedRRandPriority(n, BT, PT, quantum);
		
	
		double avgwt=r.avgWaitingTime();
		assertEquals(50.0, avgwt, 0.01);
		
	}
	
	
	
	
	
	
	@Test
	public void test3() throws Exception {
		int n =3;
		int quantum = 4;
		int BT[]= {4,3,16};
		int PT[]= {7,1,3};
		CombinedRRandPriority r=new CombinedRRandPriority(n, BT, PT, quantum);
		
	
		double avgwt=r.avgWaitingTime();
		assertEquals(74.33333333, avgwt, 0.01);
		
	}
		
	}

	
	
	
	
	


