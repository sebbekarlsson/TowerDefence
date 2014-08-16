package nu.sebka.scenes.worlds;



import nu.sebka.main.ImageLoader;
import nu.sebka.main.MapLoader;
import nu.sebka.main.MouseHandler;
import nu.sebka.scenes.GameScene;

public class World4 extends GameScene {

	public World4(){
		createStars(32);
		MouseHandler.setCursor(ImageLoader.load("/images/gui/cursor.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/5/map.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/5/top.png"));
		mobspawner.setMobs(MapLoader.loadMobs("/images/maps/5/mobs.txt"));
		
	}
	
}
