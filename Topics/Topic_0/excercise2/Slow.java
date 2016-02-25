package packageAbstractFactory;

public class Slow extends Database {

	@Override
	public String makeConn() {
		return "Type One - Slow";
	}

}