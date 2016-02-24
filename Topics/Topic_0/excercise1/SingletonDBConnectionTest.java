package packageSingleton;

public class SingletonDBConnectionTest {

	public static void main(String[] args) {
		SingletonDBConnection testSingletonDBConnection = SingletonDBConnection.getInstance();

		testSingletonDBConnection.sayHello();
	}

}
