package nu.sebka.instances;

import java.util.Random;

import nu.sebka.instances.mobs.SpiderMob;
import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.Instance;

public class MobSpawner extends Instance {

	Random random = new Random();


	public MobSpawner(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/spawner.png"));

	}

	@Override
	public void tick() {
		if(random.nextInt(32) == 0){

			Game.getCurrentScene().createInstance(new SpiderMob(x,y));


		}

	}

	@Override
	public void defaultTick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onReplacement() {
		// TODO Auto-generated method stub

	}

}
