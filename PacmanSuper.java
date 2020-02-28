package pacman;

import java.awt.Color;
import java.awt.Graphics;

public class PacmanSuper extends PacmanState {
	protected PacmanSuper (Pacman pacman) {
		super(pacman);
	}
	@Override
	public State getState() {
		return State.SUPER;
	}
	
	@Override
	public void draw(Graphics g, int height, int width) {
		g.setColor(Color.RED);
		g.fillOval(width*pacman.getCoordinate().getX()/20+2, (height-25)*pacman.getCoordinate().getY()/20+2, 20, 20);
	}
}
