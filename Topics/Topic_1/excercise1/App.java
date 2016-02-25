package local.maven.app.My_App;

/**
 * Add!
 *
 */
public class App 
{
	private int x = 0, y = 0, z= 0;
	
    public void add(){
    	setZ((getX() + getY()));
        System.out.println( "Add of " + getX() + " + " + getY() + " is: " + getZ() );
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
}