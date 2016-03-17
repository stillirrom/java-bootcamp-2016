package local.maven.finalProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOConnection {

	protected static Connection connect = null;
	protected static Statement statement = null;
	protected ResultSet resultSet = null;

	public void open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/FinalProject?user=root&password=root");
			statement = connect.createStatement();
		} catch (Exception e) {
			System.out.print(e.getStackTrace());
		}
	}

	public void close() {
		try {
			
			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e) {
			System.out.print(e.getStackTrace());
		}
	}

}
