package packageProxy;

import java.util.Date;

public class DBAccessor {

	public void sayHello() {
		System.out.println(this.getClass().getSimpleName() + " established the connection at " + new Date());
	}

}