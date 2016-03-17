package local.maven.finalProject.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import local.maven.finalProject.model.Item;

public class DAOItem extends DAOConnection {

	public DAOItem() {
	}

	public Item getItemByID(int id) {

		Item item = null;
		open();
		try {
			resultSet = statement.executeQuery("SELECT * from Item where idItem ='" + id + "';");
			if (resultSet.next()) {
				item = new Item();
				item.setIdItem(resultSet.getInt("idItem"));
				int idCategory = resultSet.getInt("Category_idCategory");
				item.getCategory().setIdCategory(idCategory);
				item.setDescription(resultSet.getString("description"));
				item.setPrice(resultSet.getDouble("price"));
				item.setTax(resultSet.getDouble("tax"));
				item.setBarcode(resultSet.getLong("barcode"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	public List<Item> getItemByCategory(int idCat) {

		List<Item> items = new LinkedList<Item>();
		open();
		try {
			resultSet = statement.executeQuery(
					"SELECT IT.idItem, IT.Category_idCategory, IT.description, IT.price, IT.tax, IT.barcode FROM Item IT, Category CA WHERE IT.Category_idCategory = '"
							+ idCat + "' and IT.Category_idCategory = CA.idCategory;");
			while (resultSet.next()) {
				Item item = new Item();
				item.setIdItem(resultSet.getInt("idItem"));
				int idCategory = resultSet.getInt("Category_idCategory");
				item.getCategory().setIdCategory(idCategory);
				item.setDescription(resultSet.getString("description"));
				item.setPrice(resultSet.getDouble("price"));
				item.setTax(resultSet.getDouble("tax"));
				item.setBarcode(resultSet.getLong("barcode"));
				items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}

	public List<Item> getItemByCartId(int idCart) {

		List<Item> items = new LinkedList<Item>();
		open();
		try {
			resultSet = statement.executeQuery(
					"SELECT IT.idItem, IT.Category_idCategory , CA.description, IT.description, IT.price, IT.tax, IT.barcode FROM Item IT, Cart Cr, Added Ad, Category CA WHERE Ad.Cart_idCart = '"
							+ idCart + "' and IT.idItem = Ad.Item_idItem and IT.Category_idCategory = CA.idCategory;");
			while (resultSet.next()) {
				Item item = new Item();
				item.setIdItem(resultSet.getInt("idItem"));
				int idCategory = resultSet.getInt("Category_idCategory");
				item.getCategory().setIdCategory(idCategory);
				item.setDescription(resultSet.getString("description"));
				item.setPrice(resultSet.getDouble("price"));
				item.setTax(resultSet.getDouble("tax"));
				item.setBarcode(resultSet.getLong("barcode"));
				items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}

	public List<Item> getItemByName(String name) {
		List<Item> items = new LinkedList<Item>();
		open();
		try {
			resultSet = statement.executeQuery(
					"SELECT IT.idItem, IT.Category_idCategory, IT.description, IT.price, IT.tax, IT.barcode FROM Item IT, Category CA WHERE IT.description LIKE '%"
							+ name + "%' and IT.Category_idCategory = CA.idCategory;");
			while (resultSet.next()) {
				Item item = new Item();
				item.setIdItem(resultSet.getInt("idItem"));
				int idCategory = resultSet.getInt("Category_idCategory");
				item.getCategory().setIdCategory(idCategory);
				item.setDescription(resultSet.getString("description"));
				item.setPrice(resultSet.getDouble("price"));
				item.setTax(resultSet.getDouble("tax"));
				item.setBarcode(resultSet.getLong("barcode"));
				items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
}