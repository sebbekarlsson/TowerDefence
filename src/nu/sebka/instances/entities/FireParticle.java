package nu.sebka.instances.entities;

import java.awt.Graphics2D;
import java.util.Random;

import nu.sebka.main.ImageLoader;

public class FireParticle extends Particle {

	Random random = new Random();
	public FireParticle(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/fire.png"));
		speed = 1.5;
		health = 25;
	}
	
	public void draw(Graphics2D g2d){
		drawRotatedSprite(g2d,sprite.getCurrentImage(),x,y,random.nextInt(360));
	}
	
	

}
