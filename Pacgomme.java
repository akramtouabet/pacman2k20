package pacman;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Pacgomme extends Object {

	protected int points;
	protected Color color;

	@Override
	public abstract void draw(Graphics g, Coordinate coordinate, int width, int height);
	
	public abstract void effect();
	
	public abstract int getPoints();
}
