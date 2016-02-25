package packageAbstractFactory;

public class Demo {

	public static void main(String[] args) {
		AbstractFactory abstractFactory = new AbstractFactory();

		SQLConnectionFactory sqlConnectionFactory1 = abstractFactory.getSQLConnectionFactory("One");
		Database sql1 = sqlConnectionFactory1.getDatabase("fast");
		System.out.println("sql1 conn: " + sql1.makeConn());
		Database sql2 = sqlConnectionFactory1.getDatabase("slow");
		System.out.println("sql2 conn: " + sql2.makeConn());

		SQLConnectionFactory sqlConnectionFactory2 = abstractFactory.getSQLConnectionFactory("Two");
		Database sql3 = sqlConnectionFactory2.getDatabase("plain");
		System.out.println("sql3 conn: " + sql3.makeConn());
		Database sql4 = sqlConnectionFactory2.getDatabase("variable");
		System.out.println("sql4 conn: " + sql4.makeConn());

	}

}