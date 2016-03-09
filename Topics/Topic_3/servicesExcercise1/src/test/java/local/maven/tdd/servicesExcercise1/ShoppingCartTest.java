package local.maven.tdd.servicesExcercise1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Class for Tests.
 * @author juan.piza
 *
 */
public class ShoppingCartTest {
	
	private ServicesShoppingCart services;
	private Item item1;
	private Item item2;
	private Item item3;
	private Item item4;
	
	@Before
	public void setUp() {
		item1 = new Item(1, "Chocolate", 1.25);
		item2 = new Item(2, "Coffee", 15.00);
		item3 = new Item(3, "Milky Way", 1.10);
		item4 = new Item(4, "Gatorade", 1.75);
		services = new ServicesImp();
	}

	@After
	public void clean() {
		services.removeCart(0);
	}
	
	@Test
	public final void createCartTest() {
		assertEquals(0, services.createCart());
	}
	
	@Test
	public final void whenItemIsDeletedThenShouldNotBeOnTheList() {
		int idCartCreated = services.createCart();
		services.addItem(item2, idCartCreated);
		services.addItem(item1, idCartCreated);
		services.addItem(item4, idCartCreated);
		services.addItem(item3, idCartCreated);		
		services.removeItem(item2, idCartCreated);
		List<Item> retrievedCart = services.retrieveCart(idCartCreated);
		assertTrue(!retrievedCart.contains(item2));
	}
	
	@Test
	public final void whenItemIsAddedThenShouldBeOnTheList() {
		int idCartCreated = services.createCart();
		services.addItem(item1, idCartCreated);
		List<Item> retrievedCart = services.retrieveCart(idCartCreated);
		assertEquals("Chocolate", retrievedCart.get(0).getName());
	}
		
	@Test
	public final void getTotalTest() {
		int idCartCreated = services.createCart();
		services.addItem(item1, idCartCreated);
		services.addItem(item2, idCartCreated);
		services.addItem(item3, idCartCreated);
		services.addItem(item4, idCartCreated);
		assertEquals(19.1, services.getTotal(idCartCreated), 0);
	}
	
	@Test
	public final void removeCartTest() {
		int idCartCreated = services.createCart();
		assertTrue(services.removeCart(idCartCreated));
		assertTrue(!services.addItem(item1, idCartCreated));
	}
	
}
