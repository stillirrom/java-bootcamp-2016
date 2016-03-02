package local.maven.tdd.mavenTddExcercise1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecentFileListTest {

	private RecentFileList recentFileList;

	@Before
	public void setUp() {
		recentFileList = new RecentFileList();
	}

	@After
	public void tearDown() {
		recentFileList.clear();
	}

	@Test
	public final void shouldBeEmpty() {
		assertTrue(recentFileList.create().isEmpty());
	}

	@Test
	public final void shouldNotBeEmpty() {
		recentFileList.create();
		assertTrue(!recentFileList.fill("First File Name").isEmpty());
	}

	@Test
	public final void shouldReturnTheSameString() {
		recentFileList.create();
		recentFileList.fill("First File Name");
		recentFileList.fill("Second File Name");
		assertEquals("Third File Name", (recentFileList.fill("Third File Name").get(0)));
	}

	@Test
	public final void shouldBumpAString() {
		recentFileList.create();
		recentFileList.fill("First File Name");
		recentFileList.fill("Second File Name");
		recentFileList.fill("Third File Name");
		assertEquals("First File Name", (recentFileList.fill("First File Name").get(0)));
	}

	@Test
	public final void shouldRemoveString() {
		recentFileList.create();
		recentFileList.fill("First File Name");
		recentFileList.fill("Second File Name");
		recentFileList.fill("Third File Name");
		recentFileList.fill("Fourth File Name");
		recentFileList.fill("Fifth File Name");
		recentFileList.fill("Sixth File Name");
		recentFileList.fill("Seventh File Name");
		recentFileList.fill("Eighth File Name");
		recentFileList.fill("Ninth File Name");
		recentFileList.fill("Tenth File Name");
		recentFileList.fill("Eleventh File Name");
		recentFileList.fill("Twelfth File Name");
		recentFileList.fill("Thirteenth File Name");
		recentFileList.fill("Fourteenth File Name");
		recentFileList.fill("Fifteenth File Name");
		assertTrue(!(recentFileList.fill("Sixteenth File Name").contains("First File Name")));
	}
}
