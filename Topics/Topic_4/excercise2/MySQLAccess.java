package local.maven.tdd.SQLExcercise2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/high_school?" + "user=root&password=root");
			statement = connect.createStatement();
			resultSet = statement.executeQuery(
					"SELECT te.lastNameTeacher, te.firstNameTeacher,  sc.daySchedule_Time, sc.hourInitialSchedule_Time, sc.hourFinalSchedule_Time, co.nameCourse from Course co, Teacher te, Student st, Enroll en, Schedule_Time sc where sc.Course_idCourse = co.idCourse and co.Teacher_idTeacher = te.idTeacher group by sc.idSchedule_Time;");
			writeResultSet(resultSet);
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		System.out.print("Last N\t");
		System.out.print("First N\t");
		System.out.print("Day\t\t");
		System.out.print("Begins\t\t");
		System.out.print("Ends\t\t");
		System.out.print("Course Name\n");
		while (resultSet.next()) {
			String lastNameTeacher = resultSet.getString("lastNameTeacher");
			String firstNameTeacher = resultSet.getString("firstNameTeacher");
			String daySchedule_Time = resultSet.getString("daySchedule_Time");
			Date hourInitialSchedule_Time = resultSet.getDate("hourInitialSchedule_Time");
			Date hourFinalSchedule_Time = resultSet.getDate("hourFinalSchedule_Time");
			String nameCourse = resultSet.getString("nameCourse");
			System.out.print("" + lastNameTeacher);
			System.out.print("\t" + firstNameTeacher);
			System.out.print("\t" + daySchedule_Time);
			System.out.print("\t" + hourInitialSchedule_Time);
			System.out.print("\t" + hourFinalSchedule_Time);
			System.out.print("\t" + nameCourse + "\n");
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}