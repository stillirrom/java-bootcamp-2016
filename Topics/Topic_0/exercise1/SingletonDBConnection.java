package packageSingleton;

public class SingletonDBConnection {

	private static SingletonDBConnection singletonDBConnection = null;

	private SingletonDBConnection() { 
	}

	public static SingletonDBConnection getInstance() {
		if (singletonDBConnection == null) {
			singletonDBConnection = new SingletonDBConnection();
		}
		return singletonDBConnection;
	}
	
	public void sayHello() {
		System.out.println("Test text to be shown");
	}
}