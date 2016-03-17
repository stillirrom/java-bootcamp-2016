package local.maven.finalProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import local.maven.finalProject.model.User;

public class DAOUser extends DAOConnection {

	private ResultSet resultSet = null;

	public DAOUser() {
	}

	public User getUserByID(int id) {
		User user = null;
		open();
		try {
			resultSet = statement.executeQuery("SELECT * from Users where idUser ='" + id + "';");
			if (resultSet.next()) {
				user = new User();
				user.setIdUser(resultSet.getInt("idUser"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				user.setNickname(resultSet.getString("nickname"));
				user.setPasswordUser(resultSet.getString("passwordUser"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User getUserByNickname(String nickname) {
		User user = null;
		open();
		try {
			resultSet = statement.executeQuery("SELECT * from Users where nickname ='" + nickname + "';");
			if (resultSet.next()) {
				user = new User();
				user.setIdUser(resultSet.getInt("idUser"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				user.setNickname(resultSet.getString("nickname"));
				user.setPasswordUser(resultSet.getString("passwordUser"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	

	public boolean createUser(User user) {
		String _firstName = user.getFirstName();
		String _lastName = user.getLastName();
		String _nickname = user.getNickname();
		String _passwordUser = user.getPasswordUser();
		int success = 0;
		open();
		try {
			success = statement.executeUpdate("INSERT INTO Users (firstName, lastName, nickname, passwordUser) VALUES ('" + _firstName
					+ "', '" + _lastName + "', '" + _nickname + "', '" + _passwordUser + "');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return (success == 1) ? true : false;
	}

	public boolean verifyUserExist(String _nickname) {
		open();
		boolean flag = false;
		try {
			resultSet = statement.executeQuery("SELECT nickname from Users;");
			while (resultSet.next()) {
				if (resultSet.getString("nickname").equals(_nickname)) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return flag;
	}

	public boolean validateUserPassword(String _nickname, String _passwordUser) {
		open();
		boolean flag = false;
		try {
			resultSet = statement.executeQuery("SELECT nickname, passwordUser from Users;");
			while (resultSet.next()) {
				if (resultSet.getString("nickname").equals(_nickname)) {
					if (resultSet.getString("passwordUser").equals(_passwordUser)) {
						flag = true;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return flag;
	}
}