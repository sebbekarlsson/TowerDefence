package nu.sebka.main.gui;

import java.awt.Graphics2D;

public abstract class GUIObject {
	
	public double x,y;
	
	public abstract void tick();
	
	public abstract void draw(Graphics2D g2d);

	
}
