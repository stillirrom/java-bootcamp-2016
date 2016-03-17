package local.maven.finalProject.model;

public class Category {

	private int idCategory;
	private String description;
	private int codeCategory;

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCodeCategory() {
		return codeCategory;
	}

	public void setCodeCategory(int codeCategory) {
		this.codeCategory = codeCategory;
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", description=" + description + ", codeCategory=" + codeCategory + "]";
	}
	
}
