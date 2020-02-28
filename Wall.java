package pacman;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Wall extends Object {
	
	public Wall(Coordinate coordinate) {
		this.objectType = objectType.wall;
		this.coordinate = coordinate;
	}
	@Override
	public void draw (Graphics g, Coordinate coordinate, int width, int height) {
		Graphics2D g2d = (Graphics2D)g;         
	    GradientPaint gp = new GradientPaint(0, 0, Color.white, 30, 30, Color.gray, true);                
	    g2d.setPaint(gp);
		g2d.drawRect(coordinate.getX()*width/20, coordinate.getY()*height/20, width/20,height/20);
	}
}
