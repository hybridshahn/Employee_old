package webapp.model;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)//메소드 순서를 네임어센딩대로 수행하겠다는 것
public class DeptTest {
	
	static Log log = LogFactory.getLog(DeptTest.class);

	
	@Test
	public void test1_Dept() {
		String s1 = new String("xxx");
		String s2 = new String("xxx");
		
		log.info("s1 == s2     :  "+(s1==s2));
		log.info("s1.equals(s2) : "+s1.equals(s2));//equal : 내용비교. 둘다 xxx 그래서 true
	}
	
	@Test
	public void test2_Dept() {
		Dept d1 = new Dept(100, "xxx", "yyy");
		Dept d2 = new Dept(100, "xxx", "yyy");
		
		log.info("d1 == d2     :  "+(d1==d2));
		log.info("d1.equals(d2) : "+d1.equals(d2));//얘도 true가 나와야하는데 false가나옴
	}
	
	@Test
	public void test3_Dept() {
		Dept d1 = new Dept(100, null, null);
		Dept d2 = new Dept(100, null, null);
		
		assertEquals(d1, d2);
	}
	
	@Test
	public void test4_Dept() {
		Dept d1 = new Dept(100, "xxx", null);
		Dept d2 = new Dept(100, null, null);
		
		assertNotEquals(d1, d2);
	}
	
	@Test
	public void test5_Dept() {
		Dept d1 = new Dept(100, "xxx", null);
		Dept d2 = new Dept(100, "xxx", null);
		
		assertEquals(d1, d2);
		
	}
	
	@Test
	public void test6_Dept() {
		Dept d1 = new Dept(100, "xxx", "yyy");
		Dept d2 = new Dept(100, "xxx", null);
		
		assertNotEquals(d1, d2);
		
	}
	
	@Test
	public void test7_Dept() {
		Dept d1 = new Dept(100, "xxx", "yyy");
		Dept d2 = new Dept(100, "xxx", "yyy");
		
		assertEquals(d1, d2);
		
	}
	
	@Test
	public void test8_Dept() {
		Dept d1 = new Dept(null, "xxx", "yyy");
		Dept d2 = new Dept(null, "xxx", "yyy");
		
		assertEquals(d1, d2);
		
	}
	

}
