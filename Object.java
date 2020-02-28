package pacman;

import java.awt.Graphics;

public abstract class Object {
		
		public static enum objectType{
			wall, empty, pacgomme
		}
		
		protected objectType objectType;
		protected Coordinate coordinate;
		
		public objectType getObjectType() {
			return this.objectType;
		}
		
		public abstract void draw(Graphics g, Coordinate coordinate, int width, int height) ;
		
	}