package nu.sebka.instances.mobs;

import nu.sebka.instances.entities.Mob;
import nu.sebka.main.ImageLoader;

public class ShipMob extends Mob {

	public ShipMob(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/mobs/ship/1.png"));
		protection = 50;
		moneyGain = 300;
		speed = 4;
	}

}
