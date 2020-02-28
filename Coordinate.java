package pacman;


public class Coordinate {

	private int y;
	private int x;

	public Coordinate(int x, int y) {
		this.y = y;
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public boolean equal(Coordinate coordinate) {
		if (this.getX() == coordinate.getX() && this.getY() == coordinate.getY())
			return true;
		else
			return false;
	}
	
	public void setCoordinate(int x, int y) {
		this.x=x;
		this.y=y;
	}

}
