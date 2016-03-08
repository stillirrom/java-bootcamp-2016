package local.maven.tdd.servicesExcercise2;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Class for Tests.
 * 
 * @author juan.piza
 *
 */
public class UserServiceTest {

	private UserServiceImp services;
	private User user1;
	private User user2;
	private User user3;
	private User user4;

	@Before
	public void setUp() {
		user1 = new User(1, "Carlos");
		user2 = new User(2, "Juan");
		user3 = new User(3, "Laura");
		user4 = new User(4, "Miguel");
		services = new UserServiceImp();
	}

	@After
	public void clean() {
		services.deleteUser(0);
	}

	@Test
	public final void createUserTest() {
		assertEquals(0, services.createUser("Carlitos"));
	}

	@Test
	public final void createTwoUsersTest() {
		services.createUser("Carlitos");
		assertEquals(0, services.createUser("Juanito"));
		assertEquals(2, services.countUsers());
	}

	@Test
	public final void retrieveUserTest() {
		assertEquals(0, services.createUser("Juanito"));
		assertEquals("Juanito", services.retrieveUser(0).getName());
	}

	@Test
	public final void updateUserTest() {
		services.createUser("Juanito");
		assertTrue(services.updateUser(0, "Carlitos"));
		assertEquals("Carlitos", services.retrieveUser(0).getName());
	}

	@Test
	public final void deleteUserTest() {
		services.createUser("Carlitos");
		assertTrue(services.deleteUser(0));
		assertEquals(0, services.countUsers());
	}

}
