package local.maven.finalProject.services;

import java.util.List;

import local.maven.finalProject.dao.DAOAdded;
import local.maven.finalProject.dao.DAOCart;
import local.maven.finalProject.dao.DAOConnection;
import local.maven.finalProject.dao.DAOItem;
import local.maven.finalProject.dao.DAOUser;
import local.maven.finalProject.model.Added;
import local.maven.finalProject.model.Cart;
import local.maven.finalProject.model.Checkout;
import local.maven.finalProject.model.Item;
import local.maven.finalProject.model.User;

public class ServicesImp implements ServicesShoppingCart {

	DAOUser daoUser = new DAOUser();
	DAOItem daoItem = new DAOItem();
	DAOCart daoCart = new DAOCart();
	DAOAdded daoAdded = new DAOAdded();
	DAOConnection daoConnection = new DAOConnection();

	public User userRegistration(User user) {
		User user_ = null;
		if (!daoUser.verifyUserExist(user.getNickname())) {
			if (daoUser.createUser(user)) {
				user_ = daoUser.getUserByNickname(user.getNickname());
			}
		}
		return user_;
	}

	public boolean userLogin(String nickname, String passwordUser) {
		return daoUser.validateUserPassword(nickname, passwordUser);
	}

	public List<Item> findProductsByCategory(int idCat) {
		return daoItem.getItemByCategory(idCat);
	}

	public List<Item> findProductsByName(String name) {
		return daoItem.getItemByName(name);
	}

	public boolean saveCart(int idItem, int idCart) {
		return daoAdded.addItem(idItem, idCart);
	}

	public Checkout buyProducts(int idCart) {
		double sumPrice = 0;
		double sumTax = 0;
		List<Item> itemByCartId = daoItem.getItemByCartId(idCart);
		Checkout checkout = null;
		if (!itemByCartId.isEmpty()) {
			checkout = new Checkout();
			for (Item item : itemByCartId) {
				sumPrice += item.getPrice();
				sumTax += (item.getTax() * item.getPrice() / 100);
			}
			checkout.setItems(itemByCartId);
			checkout.setTotalPrice(sumPrice);
			checkout.setTotalTax(sumTax);
		}
		daoCart.changePaidByCartId(idCart);
		return checkout;
	}

	public Cart getCartByUserId(int idUsr) {
		Cart cart = daoCart.getCartNotPaidByUserID(idUsr);
		if (cart == null) {
			if (daoCart.createCart(idUsr)) {
				cart = daoCart.getCartNotPaidByUserID(idUsr);
			}
		}
		return cart;
	}

	public User getUserByNickname(String nickname) {
		User user = daoUser.getUserByNickname(nickname);
		return user;
	}

	public List<Item> getItemByCartId(int idCart) {
		return daoItem.getItemByCartId(idCart);
	}

	public Added getAddedByIdItemAndIdCart(int idItem, int idCart) {
		return daoAdded.getAddedByIdItemAndIdCart(idItem, idCart);
	}

	public Added getAddedByID(int id) {
		return daoAdded.getAddedByID(id);
	}

}
