package local.maven.tdd.servicesExcercise1;

/**
 * Class for an Item. This plain class has the Setters and Getters for its
 * parameters, which are <i>id</i>, <i>name</i> and <i>price</i>. Every item
 * MUST have an ID, a name and an itemList.
 * 
 * @author juan.piza
 *
 */
public class Item {

	int id;
	String name;
	double price;

	/**
	 * Constructor method for an Item. The item MUST have an <i>id</i>, a
	 * <i>name</i> and a <i>price</i>.
	 * 
	 * @param nId
	 *            Is the ID of an Item.
	 * @param nName
	 *            Is the Name of an Item.
	 * @param nPrice
	 *            Is the Price of an Item.
	 */
	public Item(int nId, String nName, double nPrice) {
		this.id = nId;
		this.name = nName;
		this.price = nPrice;
	}

	/**
	 * Returns the id of the Item.
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the Item.
	 * 
	 * @param id,
	 *            is the id to be set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the name of the Item.
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Item.
	 * 
	 * @param name,
	 *            is the name to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the price of the Item.
	 * 
	 * @return double
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the Item.
	 * 
	 * @param price,
	 *            is the Price to be set.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
