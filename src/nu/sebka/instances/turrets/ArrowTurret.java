package nu.sebka.instances.turrets;

import java.awt.Graphics2D;

import nu.sebka.main.ImageLoader;

public class ArrowTurret extends Turret {

	
	
	public ArrowTurret(double x, double y) {
		super(x, y);
		head.images.add(ImageLoader.load("/images/turrets/arrowturret/head.png"));
		
	}
	
	
	
	
	public void draw(Graphics2D g2d){
		drawRotatedSprite(g2d,head.getCurrentImage(),direction);
	}

}
