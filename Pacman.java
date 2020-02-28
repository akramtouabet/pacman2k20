package pacman;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import pacman.PacmanState.State;


public class Pacman {
	
	private Coordinate coordinate;
	private Direction direction;
	private Game game;
	private ArrayList<PacmanObserver> observers;
	private PacmanState state;
	
	public Pacman (Game game, Coordinate coordinate) {
		observers = new ArrayList<>();
		this.game = game;
		this.coordinate = coordinate;
		this.direction=Direction.Right;
		state = new PacmanNormal(this);	
		
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate=coordinate;
	}
	
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	public void register(PacmanObserver o) {
		observers.add(o);
	}
	
	private void notifyObserver(List<PacmanEvent> events)
	{
		for(PacmanObserver pacmanObserver : observers)
			pacmanObserver.notify(events);
	}
	
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	void notifyMove(Coordinate c) {
		List<PacmanEvent> events = new ArrayList<>();
		coordinate = c;
		events.add(new PacmanEvent(c));
		notifyObserver(events);
	}
	
	public void move()
	{
		int x = coordinate.getX() + direction.getX();
		int y = coordinate.getY() + direction.getY();
		Coordinate  c = new Coordinate(x, y);
		if(game.getMaze().getSchemaContent(x, y) != -1
				&& game.getMaze().getSchemaContent(x, y) != -2
				&& game.getMaze().getSchemaContent(x, y) != -3
				&& game.getMaze().getSchemaContent(x, y) != -4
				&& game.getMaze().getSchemaContent(x, y) != -5)
		{
			notifyMove(c);
		}
		else if (game.getMaze().getSchemaContent(x, y) == -2) {
			this.setCoordinate(new Coordinate(19,3));
		}
		else if (game.getMaze().getSchemaContent(x, y) == -3) {
			this.setCoordinate(new Coordinate(0,5));
		}
		else if (game.getMaze().getSchemaContent(x, y) == -4) {
			this.setCoordinate(new Coordinate(12,19));
		}
		else if (game.getMaze().getSchemaContent(x, y) == -5) {
			this.setCoordinate(new Coordinate(1,0));
		}
		game.getCompteur().updateLives();
		for (int i=0; i<game.getGhosts().length; i++) {
			if (collision(game.getGhost(i))) {
				{
					if (state.getState() == PacmanState.State.NORMAL) {
						try {
					        Thread.sleep(3000);
						} catch (InterruptedException e) {
					        e.printStackTrace();
						}
						game.getCompteur().incDeaths();
						coordinate.setCoordinate(1, 1);
						game.getGhost(0).getCoordinate().setCoordinate(1, 10);
						game.getGhost(1).getCoordinate().setCoordinate(1, 18);
						game.getGhost(2).getCoordinate().setCoordinate(18, 16);
						game.getGhost(3).getCoordinate().setCoordinate(18, 1);
					}
					else if (state.getState() == PacmanState.State.SUPER) {
						if (collision(game.getGhost(0)))
							game.getGhost(0).getCoordinate().setCoordinate(1, 10);
						if (collision(game.getGhost(1)))
							game.getGhost(1).getCoordinate().setCoordinate(1, 18);
						if (collision(game.getGhost(2)))
							game.getGhost(2).getCoordinate().setCoordinate(18, 16);
						if (collision(game.getGhost(3)))
							game.getGhost(3).getCoordinate().setCoordinate(18, 1);
					}
				}
			}
		}
		
	}
	
	public State getState() {
		return state.getState();
	}
	
	public void setState(PacmanState state) {
		this.state=state;
	}
	
	public boolean collision(Ghost ghost) {
		if (coordinate.equal(ghost.getCoordinate())) {
			if (game.getCompteur().getLives() == 0)
				game.gameover();
			return true;
		}
			
		if ((coordinate.getX() == ghost.getCoordinate().getX() + ghost.getDirection().getX()) && (coordinate.getY() == ghost.getCoordinate().getY() + ghost.getDirection().getY())){
			if (game.getCompteur().getLives() <=0)
				game.gameover();
			return true;
		}
		if ((coordinate.getX()+ direction.getX() == ghost.getCoordinate().getX()) && (coordinate.getY()+ direction.getY() == ghost.getCoordinate().getY())){
			if (game.getCompteur().getLives() == 0)
				game.gameover();
			return true;
		}
		
		return false;
	}

	
	public void draw(Graphics g, int height, int width) {
		state.draw(g, height, width);
	}
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return direction;
	}
}