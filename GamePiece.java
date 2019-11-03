/**
 * The class that every game piece extends: fence, you, mho.
 * Includes private instance variables for the GamePiece's location, and includes a private instance variable that is a boolean 
 * which represents the state of the GamePiece: whether it's dead or not.
 * there are getters and setters for all instance variables, and there is a move method for the GamePiece which updates the location
 * accordingly.
 * 
 * @author Connie Jiang
 *      edited by Creighton
 *      documentation by Jeffrey
 *
 */
public class GamePiece {
	private int x;
	private int y;
	private boolean dead = false;
	
	/**
	 * constructor for GamePiece, initializes instance variables 
	 * @param x initial X position
	 * @param y initial Y position
	 */
	public GamePiece(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * getter for the instance variable x
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * getter for the instance variable y
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * setter for instance variable x
	 * @param coord new x value
	 */
	public void setX(int coord) {
		x = coord;
	}
	
	/**
	 * setter for instance variable y
	 * @param coord new y value
	 */
	public void setY(int coord) {
		y = coord;
	}
	
	/**
	 * getter for instance variable dead
	 * @return true if is dead, false otherwise
	 */
	public boolean getDead() {
		return dead;
	}
	
	/**
	 * setter for instance variable dead
	 * @param d new dead value
	 */
	public void setDead(boolean d) {
		dead = d;
	}
	
	/**
	 * move method for a GamePiece
	 * @param X how much the x coordinate should change by (positive to move right, negative to move left)
	 * @param Y how much the y coordinate should change by (positive to move up, negative to move down)
	 */
	public void move(int X, int Y) {
		x += X;
		y -= Y;
	}
}
