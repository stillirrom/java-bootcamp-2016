package packageAbstractFactory;

public class TypeTwoFactory extends SQLConnectionFactory {

	@Override
	public Database getDatabase(String type){
		if ("plain".equals(type)) {
			return new Plain();
		} else {
			return new Variable();
		}
	}

}