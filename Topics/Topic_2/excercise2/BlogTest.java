package local.maven.tdd.mavenTddExcercise2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlogTest {

	private Blog blog;

	@Before
	public void setUp() {
		blog = new Blog();
	}

	@After
	public void tearDown() {
		blog.clear();
	}

	@Test
	public final void shouldBeEmpty() {
		assertTrue(blog.create().isEmpty());
		Assert.assertTrue(true);
	}

	@Test
	public final void shouldNotBeEmpty() {
		blog.create();
		assertTrue(!blog.fill("First Entry").isEmpty());
		Assert.assertTrue(true);

	}

	@Test
	public final void shouldReturnTheSameString() {
		blog.create();
		blog.fill("First Entry");
		blog.fill("Second Entry");
		assertEquals("Third Entry", blog.fill("Third Entry").get(0));
	}

	@Test
	public final void ShouldDeleteString() {
		blog.create();
		blog.fill("First Entry");
		blog.fill("Second Entry");
		blog.fill("Third Entry");
		assertEquals(2, (blog.remove("Second Entry").size()));
	}

	@Test
	public final void ShouldReturnTenStrings() {
		blog.create();
		blog.fill("First Entry");
		blog.fill("Second Entry");
		blog.fill("Third Entry");
		blog.fill("Fourth Entry");
		blog.fill("Fifth Entry");
		blog.fill("Sixth Entry");
		blog.fill("Seventh Entry");
		blog.fill("Eighth Entry");
		blog.fill("Ninth Entry");
		blog.fill("Tenth Entry");
		blog.fill("Eleventh Entry");
		blog.fill("Twelfth Entry");
		blog.fill("Thirteenth Entry");
		blog.fill("Fourteenth Entry");
		blog.fill("Fifteenth Entry");
		assertEquals(10, (blog.ten().size()));
	}
}