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

	public MySQLAccess() {
	}

	public ResultSet readDataBase(String driverName, String urlConnection, String query){
		try {
			Class.forName(driverName);
			connect = DriverManager.getConnection(urlConnection);
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (Exception e) {
			System.out.print(e.getStackTrace());
		} 
		return resultSet;
	}

	public void close() {
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
			System.out.print(e.getStackTrace());
		}
	}

	public String writeResultSet(ResultSet resultSet) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("Last N\t");
		sb.append("First N\t");
		sb.append("Day\t\t");
		sb.append("Begins\t\t");
		sb.append("Ends\t\t");
		sb.append("Course Name\n");
		while (resultSet.next()) {
			String lastNameTeacher = resultSet.getString("lastNameTeacher");
			String firstNameTeacher = resultSet.getString("firstNameTeacher");
			String daySchedule_Time = resultSet.getString("daySchedule_Time");
			Date hourInitialSchedule_Time = resultSet.getTime("hourInitialSchedule_Time");
			Date hourFinalSchedule_Time = resultSet.getTime("hourFinalSchedule_Time");
			String nameCourse = resultSet.getString("nameCourse");
			sb.append("" + lastNameTeacher);
			sb.append("\t" + firstNameTeacher);
			sb.append("\t" + daySchedule_Time);
			sb.append("\t" + hourInitialSchedule_Time);
			sb.append("\t" + hourFinalSchedule_Time);
			sb.append("\t" + nameCourse + "\n");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}