package tddtest;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import tdd.Blog;

public class BlogTest {

	@Test
	public final void whenBlogIsEmptyThenNoExceptionIsThrown() {
		assertTrue(Blog.create().isEmpty());
		Assert.assertTrue(true);
	}

	@Test
	public final void whenFirstEntryIsMadeItIsAddedToTheListThenListReturnedIsNotEmpty() {
		Blog.create();
		assertTrue(!Blog.fill("First Entry").isEmpty());
		Assert.assertTrue(true);

	}
	@Test
	public final void whenNextEntriesAreMadeThoseAreAddedOnTopOfTheListThenFirstValueOfListReturnedIsTheLatestBlogEntry() {
		Blog.create();
		Blog.fill("First Entry");
		Blog.fill("Second Entry");
		assertEquals("Third Entry", Blog.fill("Third Entry").get(0));
	}

	@Test
	public final void whenEntryIsDeletedFromTheListThenTheListIsOneItemShorter() {
		Blog.create();
		Blog.fill("First Entry");
		Blog.fill("Second Entry");
		Blog.fill("Third Entry");
		assertEquals(2, (Blog.remove("Second Entry").size()));
	}

	@Test
	public final void whenAskedForTheTenMostRecentEntriesThenListIsTenItems() {
		Blog.create();
		Blog.fill("First Entry");
		Blog.fill("Second Entry");
		Blog.fill("Third Entry");
		Blog.fill("Fourth Entry");
		Blog.fill("Fifth Entry");
		Blog.fill("Sixth Entry");
		Blog.fill("Seventh Entry");
		Blog.fill("Eighth Entry");
		Blog.fill("Ninth Entry");
		Blog.fill("Tenth Entry");
		Blog.fill("Eleventh Entry");
		Blog.fill("Twelfth Entry");
		Blog.fill("Thirteenth Entry");
		Blog.fill("Fourteenth Entry");
		Blog.fill("Fifteenth Entry");
		assertEquals(10, (Blog.ten().size()));
	}
}
