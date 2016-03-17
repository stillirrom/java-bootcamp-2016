package local.maven.finalProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import local.maven.finalProject.model.Category;

public class DAOCategory extends DAOConnection {

	private ResultSet resultSet = null;

	public DAOCategory() {
	}

	public Category getCategoryByID(int id) {

		Category category = null;
		open();
		try {
			resultSet = statement.executeQuery("SELECT * from Category where idCategory ='" + id + "';");
			if (resultSet.next()) {
				category = new Category();
				category.setIdCategory(resultSet.getInt("idCategory"));
				category.setDescription(resultSet.getString("description"));
				category.setCodeCategory(resultSet.getInt("codeCategory"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}
}