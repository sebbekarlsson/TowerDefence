package nu.sebka.main;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
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

	public void drawRotatedSprite(Graphics2D g2d,BufferedImage image,double dir){

		AffineTransform reset = new AffineTransform();
		reset.rotate(0,0,0);
		Graphics2D g2 = g2d;
		g2.rotate(Math.toRadians(dir), x+image.getWidth()/2, y+image.getHeight()/2);
		g2.drawImage(image, (int)x, (int)y, null);
		g2.setTransform(reset);

	}

	public boolean isOutsideRoom(){
		int w = Game.getCurrentScene().WIDTH;
		int h = Game.getCurrentScene().HEIGHT;

		if(x < 0 || x > w || y < 0 || y > h){
			return true;
		}

		return false;
	}

	public abstract void onCreation();
	public abstract void onDestroy();
	public abstract void onReplacement();

}
