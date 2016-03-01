package tddtest;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import tdd.RecentFileList;

public class RecentFileListTest {

	@Test
	public final void whenRecentFileListIsEmptyThenNoExceptionIsThrown() {
		assertTrue(RecentFileList.create().isEmpty());
		Assert.assertTrue(true);
	}

	@Test
	public final void whenFileIsOpenedItsNameIsAddedToTheListThenListReturnedIsNotEmpty() {
		RecentFileList.create();
		assertTrue(!RecentFileList.fill("First File Name").isEmpty());
		Assert.assertTrue(true);
	}

	@Test
	public final void whenSecondFileIsOpenedItsNameIsAddedToTheListThenFirstValueOfListReturnedIsTheSameFileName() {
		RecentFileList.create();
		RecentFileList.fill("First File Name");
		RecentFileList.fill("Second File Name");
		assertEquals("Third File Name", (RecentFileList.fill("Third File Name").get(0)));
	}

	@Test
	public final void whenFileIsOpenedButItsNameIsAlreadyOnTheListThenTheNameIsBumpedToTheTop() {
		RecentFileList.create();
		RecentFileList.fill("First File Name");
		RecentFileList.fill("Second File Name");
		RecentFileList.fill("Third File Name");
		assertEquals("First File Name", (RecentFileList.fill("First File Name").get(0)));
	}

	@Test
	public final void whenFileIsOpenedButTheListIsAlreadyFullThenTheLastNameIsRemoved() {
		RecentFileList.create();
		RecentFileList.fill("First File Name");
		RecentFileList.fill("Second File Name");
		RecentFileList.fill("Third File Name");
		RecentFileList.fill("Fourth File Name");
		RecentFileList.fill("Fifth File Name");
		RecentFileList.fill("Sixth File Name");
		RecentFileList.fill("Seventh File Name");
		RecentFileList.fill("Eighth File Name");
		RecentFileList.fill("Ninth File Name");
		RecentFileList.fill("Tenth File Name");
		RecentFileList.fill("Eleventh File Name");
		RecentFileList.fill("Twelfth File Name");
		RecentFileList.fill("Thirteenth File Name");
		RecentFileList.fill("Fourteenth File Name");
		RecentFileList.fill("Fifteenth File Name");
		assertTrue(!(RecentFileList.fill("Sixteenth File Name").contains("First File Name")));
		Assert.assertTrue(true);
	}
}
