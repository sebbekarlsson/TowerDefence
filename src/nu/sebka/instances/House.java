package nu.sebka.instances;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import nu.sebka.main.ImageLoader;
import nu.sebka.main.Instance;

public class House extends Instance {

	public static double health = 100;
	
	public House(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/house.png"));
	}
	
	public void draw(Graphics2D g2d){
		drawSprite(g2d,sprite.getCurrentImage());
		g2d.setColor(Color.black);
		g2d.fillRect((int)x-4, (int)y-25, 32, 16);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SERIF,14,14));
		g2d.drawString((int)health+"", (int)x-4, (int)y-12);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void defaultTick() {
		// TODO Auto-generated method stub
		
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
