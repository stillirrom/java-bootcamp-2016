package local.maven.finalProject.model;

public class Added {

	private int idAdded;
	private Cart cart = new Cart();
	private Item item = new Item();

	public int getIdAdded() {
		return idAdded;
	}

	public void setIdAdded(int idAdded) {
		this.idAdded = idAdded;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Added [idAdded=" + idAdded + ", cart=" + cart + ", item=" + item + "]";
	}

}
