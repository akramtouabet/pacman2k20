package pacman;

import java.awt.Graphics;

public abstract class PacmanState {
	
	public static enum State {NORMAL, INVISIBLE, SUPER};

	protected Pacman pacman;

	protected PacmanState(Pacman pacman) {
		this.pacman = pacman;
	}
	
	abstract State getState();

	
	public abstract void draw(Graphics g, int height, int width);
}