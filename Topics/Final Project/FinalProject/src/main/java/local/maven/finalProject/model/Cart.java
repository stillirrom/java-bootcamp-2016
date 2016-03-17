package local.maven.finalProject.model;

public class Cart {

	private int idCart;
	private User user = new User();
	private String paid;

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "Cart [idCart=" + idCart + ", user=" + user + "]";
	}

}
