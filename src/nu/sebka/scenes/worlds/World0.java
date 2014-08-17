package nu.sebka.scenes.worlds;






import nu.sebka.main.ImageLoader;
import nu.sebka.main.MapLoader;
import nu.sebka.main.MouseHandler;

import nu.sebka.scenes.GameScene;


public class World0 extends GameScene {
	boolean stars = true;
	
	
	
	public void init(){
		createStars(32);
		MouseHandler.setCursor(ImageLoader.load("/images/gui/cursor.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/1/map.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/1/top.png"));
		mobspawner.setMobs(MapLoader.loadMobs("/images/maps/1/mobs.txt"));
		
	}
	
	

	
}
