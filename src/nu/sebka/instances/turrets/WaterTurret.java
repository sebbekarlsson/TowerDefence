package nu.sebka.instances.turrets;

import nu.sebka.main.ImageLoader;

public class WaterTurret extends Turret {

	public WaterTurret(double x, double y) {
		super(x, y);
		head.images.add(ImageLoader.load("/images/turrets/waterturret/head.png"));
	}

}
