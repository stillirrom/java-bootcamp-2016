package packageProxy;

import java.util.Date;

public class DBAccessor {

	public void sayHello() {
		System.out.println(this.getClass().getSimpleName() + " connection established at " + new Date());
	}

}