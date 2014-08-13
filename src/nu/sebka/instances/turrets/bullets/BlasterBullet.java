package nu.sebka.instances.turrets.bullets;

import nu.sebka.instances.entities.Bullet;
import nu.sebka.main.ImageLoader;

public class BlasterBullet extends Bullet {

	public BlasterBullet(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/turrets/blasterturret/bullet.png"));
		damage = 45;
	}

}
