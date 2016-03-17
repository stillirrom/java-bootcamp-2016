package local.maven.finalProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import local.maven.finalProject.model.Added;

public class DAOAdded extends DAOConnection {

	private ResultSet resultSet = null;

	public DAOAdded() {
	}

	public Added getAddedByID(int id) {
		Added added = null;
		open();
		try {
			resultSet = statement.executeQuery("SELECT * from Added where idAdded ='" + id + "';");
			if (resultSet.next()) {
				added = new Added();
				added.setIdAdded(resultSet.getInt("idAdded"));
				int idCart = resultSet.getInt("Cart_idCart");
				added.getCart().setIdCart(idCart);
				int idItem = resultSet.getInt("Item_idItem");
				added.getItem().setIdItem(idItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}

	public boolean addItem(int idItem, int idCart) {
		int success = 0;
		open();
		try {
			if (verifyItemExist(idItem)) {
				if (verifyCartExist(idCart)) {
					success = statement
							.executeUpdate("INSERT INTO Added (Item_idItem, Cart_idCart) VALUES ('" + idItem + "', '" + idCart + "');");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (success == 1) ? true : false;
	}

	public Added getAddedByIdItemAndIdCart(int idItem, int idCart) {
		Added added = null;
		open();
		try {
			resultSet = statement
					.executeQuery("SELECT * from Added where Item_idItem ='" + idItem + "' and Cart_idCart ='" + idCart + "';");
			if (resultSet.next()) {
				added = new Added();
				added.setIdAdded(resultSet.getInt("idAdded"));
				int idCrt = resultSet.getInt("Cart_idCart");
				added.getCart().setIdCart(idCrt);
				int idItm = resultSet.getInt("Item_idItem");
				added.getItem().setIdItem(idItm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}

	private boolean verifyItemExist(int idItem) {
		open();
		boolean flag = false;
		try {
			resultSet = statement.executeQuery("SELECT idItem from Item;");
			while (resultSet.next()) {
				if (resultSet.getInt("idItem") == (idItem)) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	private boolean verifyCartExist(int idCart) {
		open();
		boolean flag = false;
		try {
			resultSet = statement.executeQuery("SELECT idCart from Cart;");
			while (resultSet.next()) {
				if (resultSet.getInt("idCart") == (idCart)) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}