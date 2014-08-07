package nu.sebka.instances.mobs;

import nu.sebka.instances.Mob;
import nu.sebka.main.ImageLoader;

public class ZombieMob extends Mob {

	public ZombieMob(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/mobs/zombie/1.png"));
	}

}
