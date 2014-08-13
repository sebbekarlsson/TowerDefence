package nu.sebka.instances.turrets;

import nu.sebka.main.ImageLoader;





public class BlasterTurret extends Turret {

	
	
	public BlasterTurret(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/turrets/blasterturret/head.png"));
		radius = 245;
		SHOOT_TIME = 32;
	}
	

}
