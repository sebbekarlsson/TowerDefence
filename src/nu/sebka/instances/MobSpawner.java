package nu.sebka.instances;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import nu.sebka.instances.entities.Mob;
import nu.sebka.instances.mobs.ZombieMob;
import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.Instance;

public class MobSpawner extends Instance {

	Random random = new Random();
	public ArrayList<Mob> mobs = new ArrayList<Mob>();
	public int spawnTimer = 48;
	public boolean canSpawn = false;


	public MobSpawner(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/spawner.png"));


	}

	@Override
	public void tick() {

		if(canSpawn){
			if(mobs.size() > 0){
				
					if(spawnTimer > 0){
						spawnTimer -= 1;
					}else{
						Mob mob = mobs.get(mobs.size()-1);
						mob.x = x;
						mob.y = y;
						Game.getCurrentScene().createInstance(mob);
						mobs.remove(mobs.size()-1);
						spawnTimer = 48;
					}
				
			}
		}

		if(Game.keys[KeyEvent.VK_ENTER]){
			Game.getCurrentScene().createInstance(new ZombieMob(x,y));
			Game.keys[KeyEvent.VK_ENTER] = false;
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

	public void setMobs(ArrayList<Mob> mobs){
		this.mobs = mobs;
	}

}
