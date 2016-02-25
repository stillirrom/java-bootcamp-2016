package packageAbstractFactory;

public abstract class SQLConnectionFactory {
	public abstract Database getDatabase(String type);
}