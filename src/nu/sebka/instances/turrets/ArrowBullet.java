package nu.sebka.instances.turrets;

import nu.sebka.instances.Bullet;
import nu.sebka.main.ImageLoader;

public class ArrowBullet extends Bullet {

	public ArrowBullet(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/arrow.png"));
		
	}

}
