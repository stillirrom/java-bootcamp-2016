package local.maven.tdd.servicesExcercise2;

import java.util.ArrayList;

/**
 * Class for a UserService Implementation. This class implements the interface
 * UserService.
 * 
 * @author juan.piza
 *
 */

public class UserServiceImp implements UserService {

	private ArrayList<User> users;

	/**
	 * Constructor for the UserServiceImp class. It creates a new collection of
	 * users, named <i>users</i>
	 */
	public UserServiceImp() {
		users = new ArrayList<User>();
	}

	public int createUser(String userName) {
		User user = new User(userName);
		users.add(user);
		return user.getId();
	}

	public User retrieveUser(int nUserId) {
		for (User c : users) {
			if (c.getId() == nUserId) {
				return c;
			}
		}
		return null;
	}

	public boolean updateUser(int nUserId, String nName) {
		for (User c : users) {
			if (c.getId() == nUserId) {
				c.setName(nName);;
				return true;
			}
		}
		return false;
	}

	public boolean deleteUser(int nUserId) {
		for (User c : users) {
			if (c.getId() == nUserId) {
				users.remove(c);
				return true;
			}
		}
		return false;
	}
	
	public int countUsers(){
		return users.size();
	}

}
