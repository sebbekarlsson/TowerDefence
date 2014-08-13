package nu.sebka.instances.turrets.bullets;

import nu.sebka.instances.entities.Bullet;
import nu.sebka.main.ImageLoader;

public class MachineBullet extends Bullet {

	public MachineBullet(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/turrets/machineturret/bullet.png"));
		damage = 3;
	}

}
