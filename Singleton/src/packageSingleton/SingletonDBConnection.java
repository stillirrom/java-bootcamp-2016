package packageSingleton;

public class SingletonDBConnection {

	private static SingletonDBConnection singletonDBConnection = null; //By declaring this variable as Static, it means that it will be shared across all the possible instances of this class

	private SingletonDBConnection() { //Making this constructor private denies the possibility of instancing the object from the outside by calling SingletonDBConnection()
	//This blank space will be filled with the DB Connection Data
	}

	public static SingletonDBConnection getInstance() {
		if (singletonDBConnection == null) { //This will be true only the first time the method getInstance() is called.
			singletonDBConnection = new SingletonDBConnection(); //Calls the constructor and creates an instance of this object named singletonDBConnection
		}
		return singletonDBConnection;
	}
	
	public void sayHello() {
		System.out.println("Test text to be shown");
	}
}