package nu.sebka.scenes.worlds;

import java.util.ArrayList;

import nu.sebka.instances.Mob;
import nu.sebka.instances.mobs.SpiderMob;
import nu.sebka.instances.mobs.ZombieMob;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.MapLoader;
import nu.sebka.main.MouseHandler;
import nu.sebka.scenes.GameScene;

public class World2 extends GameScene {

	public World2(){
		MouseHandler.setCursor(ImageLoader.load("/images/gui/cursor.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/3/map.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/3/top.png"));
		ArrayList<Mob> mobs = new ArrayList<Mob>();
		
		mobs.add(new SpiderMob(mobspawner.x,mobspawner.y));
		mobs.add(new ZombieMob(mobspawner.x,mobspawner.y));
		mobs.add(new SpiderMob(mobspawner.x,mobspawner.y));
		mobs.add(new SpiderMob(mobspawner.x,mobspawner.y));
		mobs.add(new ZombieMob(mobspawner.x,mobspawner.y));
		mobs.add(new SpiderMob(mobspawner.x,mobspawner.y));
		mobs.add(new SpiderMob(mobspawner.x,mobspawner.y));
		mobs.add(new ZombieMob(mobspawner.x,mobspawner.y));
		
		mobspawner.setMobs(mobs);
		
	}
	
}