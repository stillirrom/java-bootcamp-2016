package local.maven.tdd.servicesExcercise2;

/**
 * Interface to control a Shopping Cart. The user of this interface will be able
 * to create multiple different carts, add items to a specific cart, remove
 * items from a specific cart, retrieve the collection of items of a specific
 * cart, get the sum of the prices of all the items in a specific cart, and
 * delete a specific cart.
 *
 * @author juan.piza
 *
 */
public interface UserService {
	
	/**
	 * This method creates a user. It returns a number which corresponds to the
	 * id of the user created.
	 * 
	 * @return int
	 */
	public int createUser(String userName);
	
	/**
	 * This method retrieves a User.
	 * 
	 * @param userId,
	 *            is the id of the User to be retrieved.
	 * @return User
	 */
	public User retrieveUser(int userId);
	
	/**
	 * This method updates an specific User. If the User is updated
	 * successfully, the method will return <i>true</i>, otherwise it will
	 * return <i>false</i>.
	 * 
	 * @param userId,
	 *            is the id of the user to be updated.
	 * @param userName,
	 *            is the name that will be updated in the User.
	 * @return true, false
	 */
	public boolean updateUser(int userId, String userName);

	/**
	 * This method deletes an specific User. If the User is deleted
	 * successfully, the method will return <i>true</i>, otherwise it will
	 * return <i>false</i>
	 * 
	 * @param userId,
	 *            is the id of the user to be deleted.
	 * @return true, false
	 */
	public boolean deleteUser(int userId);

}