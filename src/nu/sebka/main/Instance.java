package nu.sebka.main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Instance {
	
	public Sprite sprite = new Sprite();
	public double x, y;
	
	public Instance(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	public abstract void defaultTick();
	
	public void draw(Graphics2D g2d){
		drawSprite(g2d,sprite.getCurrentImage());
	}
	
	public void drawSprite(Graphics2D g2d,BufferedImage image){
		g2d.drawImage(image, (int)x, (int)y, null);
	}
	
	public abstract void onCreation();
	public abstract void onDestroy();
	public abstract void onReplacement();

}
