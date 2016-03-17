package local.maven.finalProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import local.maven.finalProject.model.Cart;

public class DAOCart extends DAOConnection {

	private ResultSet resultSet = null;

	public DAOCart() {
	}

	public Cart getCartByID(int id) {

		Cart cart = null;
		open();
		try {
			resultSet = statement.executeQuery("SELECT * from Cart where idCart ='" + id + "';");
			if (resultSet.next()) {
				cart = new Cart();
				cart.setIdCart(resultSet.getInt("idCart"));
				int idUser = resultSet.getInt("Users_idUser");				
				cart.getUser().setIdUser(idUser);
				cart.setPaid(resultSet.getString("paid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}
	
	public Cart getCartByUserID(int idUsr) {
		Cart cart = null;
		open();
		try {
			resultSet = statement.executeQuery("SELECT * from Cart where Users_idUser ='" + idUsr + "';");
			if (resultSet.next()) {
				cart = new Cart();
				cart.setIdCart(resultSet.getInt("idCart"));
				int idUser = resultSet.getInt("Users_idUser");				
				cart.getUser().setIdUser(idUser);
				cart.setPaid(resultSet.getString("paid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}
	
	public Cart getCartNotPaidByUserID(int idUsr) {
		Cart cart = null;
		open();
		try {
			resultSet = statement.executeQuery("SELECT * from Cart where Users_idUser ='" + idUsr + "' and paid = 'false';");
			if (resultSet.next()) {
				cart = new Cart();
				cart.setIdCart(resultSet.getInt("idCart"));
				int idUser = resultSet.getInt("Users_idUser");				
				cart.getUser().setIdUser(idUser);
				cart.setPaid(resultSet.getString("paid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}
	
	public void changePaidByCartId(int idCart) {
		open();
		try {
			statement.executeUpdate("UPDATE Cart set paid = 'true' where idCart ='" + idCart + "';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean createCart(int idUsr) {
		int success = 0;
		open();
		try {
			success = statement.executeUpdate("INSERT INTO Cart (Users_idUser) VALUES('"+ idUsr + "');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (success == 1) ? true : false;
	}
}