/**
 * 
 * @author Connie Jiang
 *
 */
public class GamePiece {
	private int x;
	private int y;
	
	public GamePiece() {
		
	}
	
	public GamePiece(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int coord) {
		x = coord;
	}
	
	public void setY(int coord) {
		y = coord;
	}
	
	public void move(int X, int Y) {
		x = X;
		y = Y;
	}
}
