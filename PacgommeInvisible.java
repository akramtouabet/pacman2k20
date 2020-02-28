package pacman;

import java.awt.Color;
import java.awt.Graphics;

public class PacgommeInvisible extends Pacgomme {
	public PacgommeInvisible(Coordinate coordinate) {
		points = 300;
		color = new Color(192, 0, 255);
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
