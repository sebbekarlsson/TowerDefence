package nu.sebka.instances;

import java.awt.event.KeyEvent;
import java.util.Random;

import nu.sebka.instances.mobs.SpiderMob;
import nu.sebka.instances.mobs.ZombieMob;
import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.Instance;

public class MobSpawner extends Instance {

	Random random = new Random();
	boolean create = true;

	public MobSpawner(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/spawner.png"));


	}

	@Override
	public void tick() {
			
		if(Game.keys[KeyEvent.VK_ENTER]){
			Game.getCurrentScene().createInstance(new SpiderMob(x,y));
			Game.keys[KeyEvent.VK_ENTER] = false;
		}
		
		if(Game.keys[KeyEvent.VK_CONTROL]){
			Game.getCurrentScene().createInstance(new ZombieMob(x,y));
			Game.keys[KeyEvent.VK_CONTROL] = false;
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
