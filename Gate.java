package pacman;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Gate extends Object {
	
	public Gate(Coordinate coordinate) {
		this.objectType = objectType.empty;
		this.coordinate = coordinate;
	}
	@Override
	public void draw (Graphics g, Coordinate coordinate, int width, int height) {
		Graphics2D g2d = (Graphics2D)g;         
	    GradientPaint gp = new GradientPaint(0, 0, Color.green, 30, 30, Color.white, true);                
	    g2d.setPaint(gp);
		g2d.fillRect(coordinate.getX()*width/20, coordinate.getY()*height/20, width/20,height/20);
	}
}
