package nu.sebka.instances.turrets;

import nu.sebka.instances.Bullet;
import nu.sebka.main.ImageLoader;

public class WaterBullet extends Bullet {

	public WaterBullet(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/turrets/waterturret/bullet.png"));
		damage = 17;
	}

}
