package nu.sebka.instances;

import java.awt.Color;
import java.awt.Graphics2D;



import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.Instance;

public class House extends Instance {

	public static double health = 100;
	
	boolean create = true;
	
	public House(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/house.png"));
	}
	
	public void draw(Graphics2D g2d){
		drawSprite(g2d,sprite.getCurrentImage());
		g2d.setColor(Color.BLACK);
		g2d.fillRect((int)x, (int)y-32, 32, 16);
		g2d.setColor(Color.white);
		g2d.drawString(health+"", (int)x, (int)y-16);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void defaultTick() {
		if(health < 1){
			Game.sceneIndex = 0;
		}
		
	}

	@Override
	public void onCreation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReplacement() {
		// TODO Auto-generated method stub
		
	}

}
