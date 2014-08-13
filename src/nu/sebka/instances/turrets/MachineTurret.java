package nu.sebka.instances.turrets;

import nu.sebka.main.ImageLoader;





public class MachineTurret extends Turret {

	
	
	public MachineTurret(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/turrets/machineturret/head.png"));
		radius = 245;
		SHOOT_TIME = 2;
	}
	

}
