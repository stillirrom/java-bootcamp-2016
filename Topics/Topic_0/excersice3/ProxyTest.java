package packageProxy;

public class ProxyTest {

	public static void main(String[] args) {

		Proxy proxy = new Proxy();

		DBAccessorTwo dbAccessorTwo = new DBAccessorTwo();
		dbAccessorTwo.sayHello();

		proxy.sayHello();
		proxy.sayHello();

	}

}
