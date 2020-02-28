package pacman;

import java.awt.Color;
import java.awt.Graphics;

public class PacgommeChanger extends Pacgomme {
	public PacgommeChanger(Coordinate coordinate) {
		points = 1000;
		color = Color.green;
		this.coordinate = coordinate;
	}
	
	public void draw(Graphics g, Coordinate coordinate, int width, int height) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillOval(width*coordinate.getX()/20 +8, height*coordinate.getY()/20 + 8, 8, 8);
	}
	public void effect() {
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return points;
	}
}
