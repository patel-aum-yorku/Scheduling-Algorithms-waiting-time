
import static org.junit.Assert.*;
import Assignment2.CombinedRRandPriority;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class test {
/*@BeforeEach
void setup() throws Exception{
	
}
@AfterEach
void tearDown() throws Exception{
	
}*/
@Test
public void test1() {
	int n=5;
	int quantum=2;
	int BT[] = {4,5,8,7,3};
	int PT[] = {3,2,2,1,3};
	CombinedRRandPriority r = new CombinedRRandPriority(n, BT, PT, quantum);
	assertEquals(13.8, r.avgWaitingTime(), 0.01);
}

@Test
public void test2() throws Exception {
	int n =3;
	int quantum = 4;
	int BT[]= {5,15,17};
	int PT[]= {3,1,2};
	CombinedRRandPriority r;
	try{
	
	r= new CombinedRRandPriority(n, BT, PT, quantum);
	
	fail();
	}
	
catch(Exception e) {
	double avgwt=r.avgWaitingTime();
	assertEquals(15.67, avgwt, 0.01);
	
}
	
	
}

private void assertEquals(double d, double avgWaitingTime, double e) {
	// TODO Auto-generated method stub
	
}
}
