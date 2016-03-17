package local.maven.finalProject.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import local.maven.finalProject.model.User;
import local.maven.finalProject.services.ServicesImp;
import local.maven.finalProject.services.ServicesShoppingCart;

public class ShoppingCartTest {
	
	private ServicesShoppingCart services;
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	
	@Before
	public void setUp(){
		services = new ServicesImp();
		user1 = new User();
		user1.setFirstName("Fred");
		user1.setLastName("Flintstone");
		user1.setNickname("Freddy");
		user1.setPasswordUser("Vilma123");
		
		user2 = new User();
		user2.setFirstName("Vilma");
		user2.setLastName("Flintstone");
		user2.setNickname("Vilmmy");
		user2.setPasswordUser("Fred123");
		
		user3 = new User();
		user3.setFirstName("Piccoro");
		user3.setLastName("Daimaku");
		user3.setNickname("Piccoro");
		user3.setPasswordUser("Gohan123");
		
		user4 = new User();
		user4.setFirstName("Rocky");
		user4.setLastName("Balboa");
		user4.setNickname("Stallion");
		user4.setPasswordUser("Rocky123");
				
	}

	@Test
	public void userRegistration() {
		assertEquals("Fred", services.userRegistration(user1).getFirstName());
	}
	
	@Test
	public void userIsAlreadyRegistred() {
		services.userRegistration(user2);
		assertEquals(null, services.userRegistration(user2));
	}
	
	@Test
	public void userLogin() {
		services.userRegistration(user3);
		assertTrue(services.userLogin("Piccoro", "Gohan123"));
	}
	
	@Test
	public void userWrongLogin() {
		services.userRegistration(user4);
		assertTrue(!services.userLogin("Stallion", "wrongPass"));
	}
	
	
	@Test
	public void findProductsByCategory() {
		assertTrue(!services.findProductsByCategory(1).isEmpty());
	}
	
	@Test
	public void findProductsByWrongCategory() {
		assertTrue(services.findProductsByCategory(4).isEmpty());
	}
	
	@Test
	public void findProductsByName() {
		assertTrue(!services.findProductsByName("choc").isEmpty());
	}
	
	@Test
	public void findProductsByWrongName() {
		assertTrue(services.findProductsByName("zzz").isEmpty());
	}
	
	@Test
	public void saveCart() {
		assertTrue(services.saveCart(1,1));
	}
	
	@Test
	public void buyProductsReturnItems() {
		assertTrue(services.buyProducts(1).getItems().size() > 0);
	}
	
	@Test
	public void buyProductsReturnPriceTotal() {
		assertTrue(services.buyProducts(1).getTotalPrice() > 0);
	}
	
	@Test
	public void buyCartWithoutProducts() {
		assertEquals(null, services.buyProducts(7));
	}

}
