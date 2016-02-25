package packageAbstractFactory;

public class AbstractFactory {

	public SQLConnectionFactory getSQLConnectionFactory(String type) {
		if ("One".equals(type)) {
			return new TypeOneFactory();
		} else {
			return new TypeTwoFactory();
		}
	}

}
