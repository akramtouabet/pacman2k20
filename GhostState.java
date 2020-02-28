package pacman;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GhostState {
	public static enum State{NORMAL, VULNERABLE};
	
	protected Ghost ghost;
	protected Color color;
	
	protected GhostState(Ghost ghost, Color color) {
		this.ghost=ghost;
		this.color=color;
	}
	
	abstract State getState();
	
	public abstract void move();
	
	public abstract void draw(Graphics g, int height, int width, Color color);
}
