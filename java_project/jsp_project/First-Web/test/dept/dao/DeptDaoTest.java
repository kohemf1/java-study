package dept.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class DeptDaoTest {
	
	Connection conn = null;
	DeptDao dao = null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
		

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDeptList() {
		assertNotNull("list 테스트 : ", dao.getDeptList(conn));
	}

	@Test
	public void testInsertDept() {
		assertSame("insert 테스트 : ", 1, dao.insertDept(conn, new Dept(500,"test","test")));
	}

	@Test
	public void testUpdateDept() {
		assertSame("update 테스트 : ", 1, dao.updateDept(conn, new Dept(500,"test1","test1")));
	}
	
	@Test
	public void testDeleteDept() {
		assertSame("delete 테스트 : ", 1, dao.deleteDept(conn, 500));
	}

	@Test
	public void testSelectByDeptno() {
		assertNotNull("SelectByDeptno", dao.selectByDeptno(conn, 10));
	}


}
