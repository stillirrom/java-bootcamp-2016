package local.maven.finalProject.model;

public class Item {

	private int idItem;
	private Category category = new Category();
	private String description;
	private double price;
	private double tax;
	private Long barcode;

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public Long getBarcode() {
		return barcode;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", category=" + category + ", description=" + description + ", price=" + price + ", tax=" + tax
				+ ", barcode=" + barcode + "]";
	}

}
