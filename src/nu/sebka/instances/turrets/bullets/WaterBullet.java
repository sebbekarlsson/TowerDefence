package nu.sebka.instances.turrets.bullets;

import nu.sebka.instances.entities.Bullet;
import nu.sebka.main.ImageLoader;

public class WaterBullet extends Bullet {

	public WaterBullet(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/turrets/waterturret/bullet.png"));
		damage = 16;
	}

}
