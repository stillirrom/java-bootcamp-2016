package local.maven.tdd.mavenTddExcercise1;

import java.util.ArrayList;
import java.util.List;

public class RecentFileList {

	private List<String> fileList = null;

	public RecentFileList() {
	}

	public List<String> create() {
		fileList = new ArrayList<String>();
		return fileList;
	}

	public List<String> clear() {
		fileList = new ArrayList<String>();
		return fileList;
	}

	public List<String> fill(String fileName) {
		int enteredBump = 0;
		if (fileList.size() <= 0) {
			fileList.add(fileName);
		} else if (fileList.size() <= 14) {
			{
				for (int i = 0; i <= (fileList.size() - 1); i++) {
					if ((fileList.get(i)).equals(fileName)) {
						bump(fileName);
						enteredBump = 1;
					}
				}
				if (enteredBump == 0) {
					fileList.add(fileName);
					for (int j = (fileList.size() - 1); j > 0; j--) {
						String temp = fileList.get(j);
						fileList.set(j, fileList.get(j - 1));
						fileList.set(j - 1, temp);
					}
				}
			}
			return fileList;
		} else if (fileList.size() >= 15) {
			for (int i = 0; i <= (fileList.size() - 1); i++) {
				if ((fileList.get(i)).equals(fileName)) {
					bump(fileName);
					enteredBump = 1;
				}
			}
			if (enteredBump == 0) {
				fileList.add(fileName);
				for (int j = (fileList.size() - 1); j > 0; j--) {
					String temp = fileList.get(j);
					fileList.set(j, fileList.get(j - 1));
					fileList.set(j - 1, temp);

				}
				for (int i = 15; i < fileList.size(); i++)
					fileList.remove(i);
			}
		}
		return fileList;
	}

	private void bump(String fileName) {
		for (int i = 0; i <= fileList.size() - 1; i++) {
			if ((fileList.get(i)).equals(fileName)) {
				for (int x = i; x > 0; x--) {
					String temp = fileList.get(x);
					fileList.set(x, fileList.get(x - 1));
					fileList.set(x - 1, temp);
				}

			}
		}
	}

}
