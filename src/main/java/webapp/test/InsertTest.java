package webapp.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import webapp.exception.DeptNotFoundException;
import webapp.model.Dept;
import webapp.model.Emp;
import webapp.service.DeptInfoService;
import webapp.util.EmployeeDataSource;

public class InsertTest {
	
	static GenericXmlApplicationContext factory;
	static Logger log = Logger.getLogger(InsertTest.class);

	//비포 에프터는 딱 한번만 수행됨 . 그래서 초기화작업함
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log.info("### setUpBeforeClass()...");
		factory = new GenericXmlApplicationContext("classpath:/webapp/resource/beans.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log.info("### tearDownAfterClass()...");
		factory.close();
	}

	@Test
	public void testInsert() throws SQLException {
		DataSource ds = factory.getBean(DataSource.class);
		
		Connection con = ds.getConnection();
		con.setAutoCommit(false);
		
		String sql = "insert into dept values (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 80);
		pstmt.setString(2, "xxx");
		pstmt.setString(3, "yyy");
		pstmt.executeUpdate();
		
		pstmt.setInt(1, 90);
		pstmt.setString(2, "xxxx");
		pstmt.setString(3, "yyyy");
		pstmt.executeUpdate();
		
		con.rollback();//일케햇는데도 롤백 안되면 진짜이상한거임
//		con.commit();
		
	}
	

}
