package nu.sebka.instances.mobs;

import nu.sebka.instances.Mob;
import nu.sebka.main.ImageLoader;

public class SpiderMob extends Mob {

	public SpiderMob(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/mobs/spider/1.png"));
	}

}
