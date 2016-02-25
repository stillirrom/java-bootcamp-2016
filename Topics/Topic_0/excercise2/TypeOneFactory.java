package packageAbstractFactory;

public class TypeOneFactory extends SQLConnectionFactory {

	@Override
	public Database getDatabase(String type){
		if ("fast".equals(type)) {
			return new Fast();
		} else {
			return new Slow();
		}
	}

}