package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ghost {
	private Coordinate coordinate;
	private Color color;
	private Direction direction;
	private Game game;
	private ArrayList<GhostObserver> observers;
	private GhostState state;
	
	public Ghost(Game game, Coordinate coordinate, Color color) {
		this.coordinate=coordinate;
		this.game=game;
		this.color=color;
		observers = new ArrayList<>();
		direction=Direction.Up;
		state = new GhostNormal(this, color);
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public Game getGame() {
		return game;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public void randomDirection() {
		Random rnd = new Random();
		int n = rnd.nextInt(4);
		if (n==0)
			direction = Direction.Up;
		else if (n==1)
			direction = Direction.Down;
		else if (n==2)
			direction = Direction.Left;
		else
			direction = Direction.Right;
	}
	

	
	public void register(GhostObserver o) {
		observers.add(o);
	}
	
	private void notifyObserver(List<GhostEvent> events)
	{
		for(GhostObserver GhostObserver : observers)
			GhostObserver.notifyGhost(events);
	}
	
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	public void move()
	{
		state.move();
	}
	
	public void notifyMove(Coordinate c) {
		List<GhostEvent> events = new ArrayList<>();
		coordinate = c;
		events.add(new GhostEvent(c));
		notifyObserver(events);
	}

	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.color=color;
	}
	public void draw(Graphics g, int height, int width, Color color) {
		state.draw(g,width,height, color);
	}
	
	public void setState(GhostState state) {
		this.state=state;
	}
	public GhostState getState() {
		return state;
	}
}
