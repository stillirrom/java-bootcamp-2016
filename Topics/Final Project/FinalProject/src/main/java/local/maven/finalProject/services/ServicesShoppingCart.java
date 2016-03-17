package local.maven.finalProject.services;

import local.maven.finalProject.model.User;

import java.util.List;

import local.maven.finalProject.model.Item;
import local.maven.finalProject.model.Added;
import local.maven.finalProject.model.Cart;
import local.maven.finalProject.model.Checkout;

public interface ServicesShoppingCart {
	
	public User userRegistration(User user);
	public boolean userLogin(String nickname, String passwordUser);
	public List<Item> findProductsByCategory(int idCat);
	public List<Item> findProductsByName(String name);
	public boolean saveCart(int idItem, int idCart);
	public Checkout buyProducts(int idCart);
	
	public User getUserByNickname(String nickname);
	public Cart getCartByUserId(int idUsr);
	public List<Item> getItemByCartId(int idCart);
	public Added getAddedByIdItemAndIdCart(int idItem, int idCart);
	public Added getAddedByID(int id);
	
}