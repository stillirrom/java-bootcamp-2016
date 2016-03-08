package local.maven.tdd.servicesExcercise1;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for a Collection of Carts. This plain class has the Setters and Getters
 * for its parameters, which is <i>listCart</i>. The listCart will have all the
 * carts created.
 * 
 * @author juan.piza
 *
 */
public class CartCollection {

	private List<Cart> listCart;

	public CartCollection() {
		listCart = new ArrayList<Cart>();
	}

	/**
	 * Returns the Collection of Carts.
	 * 
	 * @return the listCart
	 */
	public List<Cart> getListCart() {
		return listCart;
	}

}
