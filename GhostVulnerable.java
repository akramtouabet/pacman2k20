package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GhostVulnerable extends GhostState {
	
	private boolean slow = true;
	
	public void setSlow() {
		if (slow)
			slow = false;
		else
			slow = true;
	}
	protected GhostVulnerable(Ghost ghost, Color color) {
		super(ghost, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	State getState() {
		// TODO Auto-generated method stub
		return State.VULNERABLE;
	}

	@Override
	public void draw(Graphics g, int height, int width, Color color) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect(width*ghost.getCoordinate().getX()/20+2, (height-25)*ghost.getCoordinate().getY()/20+2, 20, 20);
	}
	
	
	public void move() {
		setSlow();
		//if (slow) {
			int x = ghost.getCoordinate().getX() + ghost.getDirection().getX();
			int y = ghost.getCoordinate().getY() + ghost.getDirection().getY();
			Coordinate  c = new Coordinate(x, y);
			switch (ghost.getGame().getMaze().getSchemaContent(x, y)) {
				case -2:
					ghost.setCoordinate(new Coordinate(19,3));
					break;
				case -3:
					ghost.setCoordinate(new Coordinate(0,5));
					break;
				
				case -4:
					ghost.setCoordinate(new Coordinate(12,19));
					break;
				
				case -5:
					ghost.setCoordinate(new Coordinate(1,0));
					break;
				case -1:
					ghost.randomDirection();
					break;
				default:
					ghost.notifyMove(c);
			}
		//}
		}
	}
