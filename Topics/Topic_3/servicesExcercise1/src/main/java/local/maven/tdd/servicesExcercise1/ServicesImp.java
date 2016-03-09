package local.maven.tdd.servicesExcercise1;

import java.util.ArrayList;


/**
 * Class for a Services Implementation. This class implements the interface ServicesShoppingCart.
 * @author juan.piza
 *
 */

public class ServicesImp implements ServicesShoppingCart {

	private CartCollection cartCollection;
	
	/**
	 * Constructor for the ServicesImp class.
	 * It creates a new collection of carts, named <i>cartCollection</i>
	 */
	public ServicesImp() {
		cartCollection = new CartCollection();
	}
	
	public boolean removeCart(int nCartId) {
		for (Cart c : cartCollection.getListCart()) {
			if (c.getId() == nCartId) {
				cartCollection.getListCart().remove(c);
				return true;
			}
		}
		return false;
	}

	public int createCart() {
		Cart cart = new Cart();
		cartCollection.getListCart().add(cart);
		return cart.getId();
	}

	public boolean addItem(Item nItem, int nCartId) {
		for (Cart c : cartCollection.getListCart()) {
			if (c.getId() == nCartId) {
				c.getItemList().add(nItem);
				return true;
			}
		}
		return false;
	}

	public boolean removeItem(Item nItem, int nCartId) {
		for (Cart c : cartCollection.getListCart()) {
			if (c.getId() == nCartId) {
				c.getItemList().remove(nItem);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Item> retrieveCart(int nCartId) {
		for (Cart c : cartCollection.getListCart()) {
			if (c.getId() == nCartId) {
				return c.getItemList();
			}
		}
		return null;
	}
	
	public double getTotal(int nCartId) {
		double acum = 0;
		for (Cart c : cartCollection.getListCart()) {
			if (c.getId() == nCartId) {
				for (Item d : c.getItemList()) {
					acum = acum + d.getPrice();
				}
			}
		}
		return acum;		
	}
	
}
