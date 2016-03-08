package local.maven.tdd.servicesExcercise2;

/**
 * Class for a User. This plain class has the Setters and Getters for
 * its parameters, which are <i>id</i> and <i>name</i>. Every car MUST have
 * an ID and a name.
 * 
 * @author juan.piza
 *
 */
public class User {
	
	private int id;
	private String name;
	
	/**
	 * Constructor method for an User. The user MUST have an <i>id</i>, and a
	 * <i>name</i>.
	 * 
	 * @param nId
	 *            Is the ID of an User.
	 * @param nName
	 *            Is the Name of an User.
	 */
	public User(String nName) {
		this.id = createId();
		this.name = nName;
	}
	
	public User(int nId, String nName) {
		this.id = nId;
		this.name = nName;
	}

	private int createId() {
		return 0;
	}

	/**
	 * Returns the id of the User.
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets an id to the User.
	 * @param id, the id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the name of the User.
	 * @return string
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a name to the User.
	 * @param name, the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
