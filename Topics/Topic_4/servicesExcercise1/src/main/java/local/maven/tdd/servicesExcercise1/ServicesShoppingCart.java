package local.maven.tdd.servicesExcercise1;

import java.util.List;

/**
 * Interface to control a Shopping Cart. The user of this interface will be able
 * to create multiple different carts, add items to a specific cart, remove
 * items from a specific cart, retrieve the collection of items of a specific
 * cart, get the sum of the prices of all the items in a specific cart, and
 * delete a specific cart.
 *
 * @author juan.piza
 *
 */
public interface ServicesShoppingCart {
	/**
	 * This method creates a cart. 
	 * 
	 * @return Returns a number which corresponds to the
	 * id of the cart created.
	 */
	public int createCart();

	/**
	 * This method adds an item to an specific cart. If the Item is added
	 * successfully, the method will return <i>true</i>, otherwise it will
	 * return <i>false</i>
	 * 
	 * @param item,
	 *            is the Item Object to be added.
	 * @param cartId,
	 *            is the id of the cart to which the Item will be add.
	 * @return true, false
	 */
	public boolean addItem(Item item, int cartId);

	/**
	 * This method removes an item from an specific cart. If the Item is removed
	 * successfully, the method will return <i>true</i>, otherwise it will
	 * return <i>false</i>.
	 * 
	 * @param item,
	 *            is the Item Object to be removed.
	 * @param cartId,
	 *            is the id of the cart to which the Item will be removed.
	 * @return true, false
	 */
	public boolean removeItem(Item item, int cartId);

	/**
	 * This method retrieves a collection of Items from a specific cart.
	 * 
	 * @param cartId,
	 *            is the id of the cart to which the itemList will be retrieved.
	 * @return true, false
	 */
	public List<Item> retrieveCart(int cartId);

	/**
	 * This method sums the prices of all the items in a specific cart. It
	 * returns the sum of the prices of all the items in a specific cart.
	 * 
	 * @param cartId,
	 *            is the id of the cart to which the sum of the product's prices
	 *            will be made.
	 * @return double
	 */
	public double getTotal(int cartId);

	/**
	 * This method removes a specific cart from the collection of carts. If the
	 * cart is removed successfully, the method will return <i>true</i>,
	 * otherwise it will return <i>false</i>.
	 * 
	 * @param cartId,
	 *            is the id of the cart to be removed.
	 * @return true, false
	 */
	public boolean removeCart(int cartId);
}