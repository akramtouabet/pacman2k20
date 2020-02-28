package pacman;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import pacman.PacmanObserver;
import pacman.PacmanState.State;
import pacman.Coordinate;

import java.awt.*;

import java.util.List;

public class Maze extends JComponent implements PacmanObserver, GhostObserver{
	private Game game;
	private Object[][] mazeMatrix;
	/*
	 * -1	: Wall
	 * 0	: Empty
	 * 1	: Blue Pacgomme
	 * 2	: Purple Pacgomme
	 * 3	: Orange Pacgomme
	 * 4	: Green Pacgomme
	 */
	private   int[][] Schema = 	{   
						    		{ -1,-1,-1,-1,-1,-2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1} , //1
							        { -1,4,1,1,-1,1,-1,-1,1,1,1,1,1,1,1,1,1,-1,1,-1} ,//2
							        { -1,1,-1,1,-1,1,-1,-1,1,-1,1,-1,1,-1,-1,-1,1,-1,1,-1} ,//3
							        { -1,1,-1,1,1,1,1,1,1,-1,1,-1,1,1,1,1,1,1,1,-1} ,//4
							        { -1,1,-1,1,-1,1,-1,-1,1,-1,1,-1,1,-1,-1,-1,1,-1,1,-1} ,//5
							        { -1,1,-1,1,1,2,-1,-1,1,1,1,-1,1,-1,-1,-1,1,-1,1,-1} ,//6
							        { -1,1,-1,0,-1,-1,-1,-1,-1,1,-1,-1,1,1,-1,-1,1,-1,1,-1} ,//7
							        { -1,1,1,1,-1,-1,-1,-1,-1,1,-1,-1,-1,1,-1,-1,1,-1,1,-1} ,//8
							        { -1,-1,1,-1,1,1,1,1,1,1,1,-1,-1,1,-1,-1,1,-1,1,-1} ,//9
							        { -1,-1,1,-1,2,-1,-1,-1,-1,-1,1,1,1,1,1,1,1,-1,1,-1} ,//11
							        { -1,1,1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1} ,//11
							        { -1,3,-1,-1,1,-1,1,1,1,1,1,1,3,1,1,-1,-1,-1,1,-1} ,//12
							        { -1,1,-1,-1,1,-1,1,-1,-1,-1,1,-1,-1,-1,1,-1,1,1,1,-1} ,//13
							        { -1,1,-1,-1,0,-1,1,1,1,1,1,-1,-1,-1,1,-1,1,-1,-1,-1} ,//14
							        { -1,1,1,1,1,1,-1,-1,-1,-1,1,-1,-1,-1,1,-1,1,-1,-1,-1} ,//15
							        { -1,1,-1,-1,-1,1,-1,1,1,1,1,1,1,1,1,-1,1,-1,-1,-1} ,//16
							        { -1,1,1,1,1,1,-1,1,-1,1,-1,1,-1,-1,-1,-1,1,-1,-1,-1} ,//17
							        { -1,1,-1,1,-1,1,-1,1,-1,1,-1,1,-1,-1,-1,-1,1,-1,-1,-1},//18
									{ -1,1,-1,1,-1,1,1,1,1,1,1,1,1,1,1,1,1,-1,-1,-1},//19
									{ -1,-1,-1,-3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}//20
								};
	public Maze(Game game) {
		this.game=game;
		this.mazeMatrix = new Object[20][20];
		this.affect();
	}
	
	public void  changeMaze() {
		// TODO Auto-generated constructor stub
		game.getMaze().setSchemaContent(19, 3, -1);
		game.getMaze().setSchemaContent(0, 5, -1);
		game.getMaze().setSchemaContent(17, 18, 1);
		game.getMaze().setSchemaContent(18, 18, 1);
		game.getMaze().setSchemaContent(16, 18, 1);
		game.getMaze().setSchemaContent(15, 18, 1);
		game.getMaze().setSchemaContent(14, 18, 1);
		game.getMaze().setSchemaContent(13, 18, 1);
		game.getMaze().setSchemaContent(18, 17, 1);
		game.getMaze().setSchemaContent(4, 14, 1);
		game.getMaze().setSchemaContent(5, 14, 1);
		game.getMaze().setSchemaContent(5, 15, 1);
		game.getMaze().setSchemaContent(12, 12, 1);
		game.getMaze().setSchemaContent(13, 12, 1);
		game.getMaze().setSchemaContent(14, 12, 1);
		game.getMaze().setSchemaContent(1, 0, -4);
		game.getMaze().setSchemaContent(12, 19, -5);
	}
	
	public void setSchema(int[][] Schema) {
		this.Schema=Schema;
	}

	public void affect() {
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++) {
				switch (Schema[i][j]) {
					case -1:
						mazeMatrix[i][j] = new Wall(new Coordinate(i,j));
						break;
					case 0:
						mazeMatrix[i][j] = new Empty(new Coordinate(i,j));
						break;
					case -2:
					case -3:
					case -4:
					case -5:
						mazeMatrix[i][j] = new Gate(new Coordinate(i,j));
						break;
					case 1:
						mazeMatrix[i][j] = new PacgommeNormal(new Coordinate(i,j));
						break;
					case 2:
						mazeMatrix[i][j] = new PacgommeInvisible(new Coordinate(i,j));
						break;
					case 3:
						mazeMatrix[i][j] = new PacgommeSuper(new Coordinate(i,j));
						break;
					case 4:
						mazeMatrix[i][j] = new PacgommeChanger(new Coordinate(i,j));
						break;
				}
			}
		}
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++) {
				mazeMatrix[i][j].draw(g, new Coordinate(i,j), getWidth(), getHeight()-25);
			}
		}
		for (int i=0; i<game.getGhosts().length; i++)
		game.getGhost(i).draw(g, getHeight(), getWidth(),game.getGhost(i).getColor());
		
		game.getPacman().draw(g, getHeight(), getWidth());
		
		g.setColor(Color.green);	
		g.drawString("Score : "+game.getCompteur().getScore(), 10,478);  
		g.setColor(Color.white);
		g.drawString("Lives :"+ game.getCompteur().getLives()+" ", 430,478);
		g.setColor(Color.red);
		g.drawString("Akram TOUABET - Sonia BenYahia", 150,478);   
	 }
	
	public Object getMatrixContent(int i, int j) {
		return mazeMatrix[i][j];
	}
	
	public int getSchemaContent(int x, int y) {
		return Schema[x][y];
	}
	
	public void setSchemaContent(int x, int y, int val) {
		Schema[x][y] = val;
	}
	
	public void eaten(int x, int y) {
		if (Schema[x][y]==-2 || Schema[x][y]==-3 || Schema[x][y]==-4 || Schema[x][y]==-5) {
		}
		else {
			this.Schema[x][y] = 0;
		}
	}
	
	
	 public void notifyGhost(List<GhostEvent> events) {
		// TODO Auto-generated method stub
		for(int i = 0; i < events.size(); i++) {
			repaint();
			boolean gameover=true;
			for (int j=0; j<20; j++) {
				for (int k=0; k<20; k++) {
					if (game.getMaze().getSchemaContent(j, k) == 1 || game.getMaze().getSchemaContent(j, k) == 2 || game.getMaze().getSchemaContent(j, k) == 3 || game.getMaze().getSchemaContent(j, k) == 4){
						gameover = false;
					}
				}
			}
			if (gameover) {
				game.gameover();
			}
		}
	}
	
	@Override
	public void notify(List<PacmanEvent> events) {
		// TODO Auto-generated method stub
		for(int i = 0; i < events.size(); i++)
		{
			repaint();	
		}
	}
}
