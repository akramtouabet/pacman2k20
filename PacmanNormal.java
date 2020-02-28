package pacman;

import java.awt.Color;
import java.awt.Graphics;

public class PacmanNormal extends PacmanState {
	protected PacmanNormal (Pacman pacman) {
		super(pacman);
	}
	@Override
	public State getState() {
		return State.NORMAL;
	}
	
	@Override
	public void draw(Graphics g, int height, int width) {
		g.setColor(Color.yellow);
		g.fillOval(width*pacman.getCoordinate().getX()/20+2, (height-25)*pacman.getCoordinate().getY()/20+2, 20, 20);
	}
	
	
}
