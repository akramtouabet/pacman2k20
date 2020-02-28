package pacman;

import java.awt.Color;

import javax.swing.JOptionPane;

import pacman.PacmanState.State;

public class Game {
	
	private static final int SPECIAL_PACMAN_TIME = 25;
	
	private Pacman pacman;
	private Maze maze;
	private Compteur compteur;
	private int height;
	private int width;
	private Gui gui;
	private Ghost[] ghost;
	private int timer;
	
	public Game(int height, int width, Coordinate coordinate, Gui gui) {
		pacman = new Pacman(this, new Coordinate(1,1));
		ghost = new Ghost[4];
		ghost[0] = new Ghost(this, new Coordinate(1,10), Color.red);
		ghost[1] = new Ghost(this, new Coordinate(1,18), Color.white);
		ghost[2] = new Ghost(this, new Coordinate(18,16), Color.magenta);
		ghost[3] = new Ghost(this, new Coordinate(18,1), Color.cyan);
		maze = new Maze(this);
		compteur = new Compteur();
		this.height=height;
		this.width=width;
		this.gui=gui;
		timer=SPECIAL_PACMAN_TIME;
	}

	public int getHeight() {
		return height;
	}
	
	public Ghost getGhost(int i) {
		return ghost[i];
	}
	public Ghost[] getGhosts() {
		return ghost;
	}
	
	public void gameover() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Game over ! \n Start a new game ?", "Game over !!", dialogButton);
		if(dialogResult == 0) {
			gui.setVisible(false);
			gui.dispose();
			gui = new Gui();
		} else {
		  System.exit(0);
		} 
	  }
	
	public int getWidth() {
		return width;
	}
	
	public Pacman getPacman() {
		return this.pacman;
	}

	public Maze getMaze() {
		// TODO Auto-generated method stub
		return maze;
	}

	public void step() {
		// TODO Auto-generated method stub
		for (int i=0; i<ghost.length; i++)
			ghost[i].move();
		pacman.move();
		
		switch (this.getMaze().getSchemaContent(this.getPacman().getCoordinate().getX(), this.getPacman().getCoordinate().getY())) {
		case 1:
			this.getCompteur().incScore(100);
			break;
		case 2:
			this.getPacman().setState(new PacmanInvisible(this.getPacman()));
			ghost[0].setState(new GhostNormal(ghost[0], Color.red));
			ghost[1].setState(new GhostNormal(ghost[1], Color.white));
			ghost[2].setState(new GhostNormal(ghost[2], Color.magenta));
			ghost[3].setState(new GhostNormal(ghost[3], Color.cyan));
			this.getCompteur().incScore(300);
			timer=SPECIAL_PACMAN_TIME;
			break;
		case 3:
			this.getPacman().setState(new PacmanSuper(this.getPacman()));
			for (int i=0; i<ghost.length; i++)
				ghost[i].setState(new GhostVulnerable(ghost[i], Color.blue));
			this.getCompteur().incScore(500);
			timer=SPECIAL_PACMAN_TIME;
			break;
		case 4:
			this.getMaze().changeMaze();
			this.getCompteur().incScore(1000);
			break;
		}
		if (pacman.getState()==State.INVISIBLE || pacman.getState() == State.SUPER) {
			if (timer>0)
				timer--;
			else {
				pacman.setState(new PacmanNormal(this.getPacman()));
				ghost[0].setState(new GhostNormal(ghost[0], Color.red));
				ghost[1].setState(new GhostNormal(ghost[1], Color.white));
				ghost[2].setState(new GhostNormal(ghost[2], Color.magenta));
				ghost[3].setState(new GhostNormal(ghost[3], Color.cyan));
			}
		}
		this.getMaze().eaten(this.getPacman().getCoordinate().getX(), this.getPacman().getCoordinate().getY());;
		this.getMaze().affect();
	}
	public Compteur getCompteur() {
		return compteur;
	}
}
