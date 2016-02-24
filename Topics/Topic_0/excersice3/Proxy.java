package packageProxy;

import java.util.Date;

public class Proxy {

	DBAccessorOne dbAccessorOne;

	public Proxy() {
		System.out.println("Creating proxy at " + new Date());
	}

	public void sayHello() {
		if (dbAccessorOne == null) {
			dbAccessorOne = new DBAccessorOne();
		}
		dbAccessorOne.sayHello();
	}

}