package local.maven.tdd.mavenTddExcercise2;

import java.util.ArrayList;
import java.util.List;

public class Blog {

	private List<String> blog = null;
	private List<String> blogTen = null;

	public Blog() {
	}

	public List<String> create() {
		blog = new ArrayList<String>();
		return blog;
	}

	public List<String> clear() {
		blog = new ArrayList<String>();
		return blog;
	}

	public List<String> fill(String blogEntry) {
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

	public List<String> remove(String blogEntry) {
		for (int i = 0; i <= (blog.size() - 1); i++) {
			if (blog.get(i).equals(blogEntry)) {
				String temp = "null";
				blog.set(i, blog.get(i + 1));
				blog.set((i + 1), temp);
			}
		}
		blog.remove(blog.size() - 1);
		return blog;
	}

	public List<String> ten() {
		blogTen = new ArrayList<String>();
		for (int i = 0; i <= 9; i++) {
			blogTen.add(i, blog.get(i));
		}
		return blogTen;
	}
}
