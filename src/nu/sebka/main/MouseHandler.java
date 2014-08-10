package nu.sebka.main;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class MouseHandler {

	private static int mx = 0;
	private static int my = 0;
	
	public static Cursor cursor;
	
	public static void draw(Graphics2D g2d){
	
	}

	public static void setMousePosition(int x, int y){
		mx = x;
		my = y;
	}
	
	public static Point getMousePosition(){
		return new Point(mx,my);
	}
	
	public static void setCursor(BufferedImage image){
		
		cursor = Toolkit.getDefaultToolkit().createCustomCursor(
			    image, new Point(0, 0), "Cursor");
		
		Game.frame.setCursor(cursor);
	}
	
	
	
}
