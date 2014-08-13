package nu.sebka.instances.turrets.bullets;

import nu.sebka.instances.entities.Bullet;
import nu.sebka.main.ImageLoader;

public class LaserBullet extends Bullet {

	public LaserBullet(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/turrets/laserturret/bullet.png"));
		damage = 32;
	}

}
