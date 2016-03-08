package local.maven.tdd.servicesExcercise1;

import java.util.ArrayList;

/**
 * Class for a Shopping Cart. This plain class has the Setters and Getters for
 * its parameters, which are <i>id</i> and <i>itemList</i>. Every car MUST have
 * an ID and an itemList.
 * 
 * @author juan.piza
 *
 */

public class Cart {

	private int id;
	private ArrayList<Item> itemList;

	/**
	 * Constructor for the Cart class. Uses the private method <i>createId()</i>
	 * to create an id, and creates an <i>ArrayList</i> of <i>Item</i>.
	 */
	public Cart() {
		id = createId();
		itemList = new ArrayList<Item>();
	}

	/**
	 * This method creates the cart's ID. This method is transitory and will
	 * contain the code to self-generate the Cart id.
	 * 
	 * @return 0
	 */
	private int createId() {
		return 0;
	}

	/**
	 * Returns the id of a Cart.
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of a Cart.
	 * 
	 * @param id,
	 *            is the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the collection of Items in a List.
	 * 
	 * @return itemList
	 */
	public ArrayList<Item> getItemList() {
		return itemList;
	}

}
