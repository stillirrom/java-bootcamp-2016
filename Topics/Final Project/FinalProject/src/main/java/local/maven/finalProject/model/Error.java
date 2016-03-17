package local.maven.finalProject.model;

public class Error {
	
	private int idError;
	private String txtError;
	
	public Error (int idError, String txtError){		
		this.idError = idError;
		this.txtError = txtError;		
	}
	
	public int getIdError() {
		return idError;
	}
	public void setIdError(int idError) {
		this.idError = idError;
	}
	public String getTxtError() {
		return txtError;
	}
	public void setTxtError(String txtError) {
		this.txtError = txtError;
	}

}
