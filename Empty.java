package pacman;

import java.awt.Graphics;

public class Empty extends Object {
	
	public Empty(Coordinate coordinate) {
		this.objectType = objectType.empty;
		this.coordinate = coordinate;
	}
	@Override
	public void draw (Graphics g, Coordinate coordinate, int width, int height) {
		
	}
}
