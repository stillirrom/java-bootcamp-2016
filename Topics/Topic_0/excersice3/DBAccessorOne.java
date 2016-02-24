package packageProxy;

public class DBAccessorOne extends DBAccessor {

	public DBAccessorOne() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}