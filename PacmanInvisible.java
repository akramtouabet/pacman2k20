package pacman;

import java.awt.Color;
import java.awt.Graphics;

public class PacmanInvisible extends PacmanState {
	protected PacmanInvisible (Pacman pacman) {
		super(pacman);
	}
	@Override
	public State getState() {
		return State.INVISIBLE;
	}
	
	@Override
	public void draw(Graphics g, int height, int width) {
		g.setColor(new Color(255, 255, 153));
		g.fillOval(width*pacman.getCoordinate().getX()/20+2, (height-25)*pacman.getCoordinate().getY()/20+2, 20, 20);
	}
	
	
}
