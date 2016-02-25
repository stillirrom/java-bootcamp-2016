package packageAbstractFactory;

public class Plain extends Database {

	@Override
	public String makeConn() {
		return "Type Two - Plain";
	}

}