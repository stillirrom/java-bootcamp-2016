package tdd;

import java.util.ArrayList;
import java.util.List;

public class Blog {

	private static List blog = null;
	private static List blogTen = null;

	private Blog() {
	}

	public static List create() {
		blog = new ArrayList();
		return blog;
	}

	public static List fill(String blogEntry) {
		if (blog.size() <= 0) {
			blog.add(blogEntry);
		} else {
			blog.add(blogEntry);
			for (int i = (blog.size() - 1); i > 0; i--) {
				String temp = (String) blog.get(i);
				blog.set(i, blog.get(i - 1));
				blog.set(i - 1, temp);
			}
		}
		return blog;
	}

	public static List remove(String blogEntry) {
		for (int i = 0; i <= (blog.size() - 1); i++) {
			if (blog.get(i).equals(blogEntry)) {
				String temp = "null";
				blog.set(i, blog.get(i + 1));
				blog.set((i + 1), temp);
			}
		}
		blog.remove(blog.size()-1);
		return blog;
	}

	public static List ten() {
		blogTen = new ArrayList();
		for (int i = 0; i <= 9; i++) {
			blogTen.add(i, blog.get(i));
		}
		return blogTen;
	}
}
