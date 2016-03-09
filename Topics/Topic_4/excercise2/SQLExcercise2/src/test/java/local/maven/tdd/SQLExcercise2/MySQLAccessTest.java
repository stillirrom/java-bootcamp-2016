package local.maven.tdd.SQLExcercise2;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MySQLAccessTest{
	
	private MySQLAccess access;
	private ResultSet resultSetDummy;
	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final static String URL_CONNECTION = "jdbc:mysql://localhost/high_school?user=root&password=root";
	private final static String QUERY = "SELECT te.lastNameTeacher, te.firstNameTeacher,  sc.daySchedule_Time, sc.hourInitialSchedule_Time, sc.hourFinalSchedule_Time, co.nameCourse from Course co, Teacher te, Student st, Enroll en, Schedule_Time sc where sc.Course_idCourse = co.idCourse and co.Teacher_idTeacher = te.idTeacher group by sc.idSchedule_Time;";
	
	@Before
	public void setUp () throws Exception {
		access = new MySQLAccess();
	}
	
	@After
	public void clean () throws Exception {
		access.close();
	}
	
	@Test
	public final void returnsResultSet() throws Exception {		
		assertNotEquals(resultSetDummy, access.readDataBase(DRIVER_NAME, URL_CONNECTION, QUERY)) ;
	}
	
	@Test
	public final void ResultSetContainsAGivenName() throws Exception {
		ResultSet granted = access.readDataBase(DRIVER_NAME, URL_CONNECTION, QUERY);
		access.writeResultSet(granted);
	}
	
}


