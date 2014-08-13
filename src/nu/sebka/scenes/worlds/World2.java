package nu.sebka.scenes.worlds;



import nu.sebka.main.ImageLoader;
import nu.sebka.main.MapLoader;
import nu.sebka.main.MouseHandler;
import nu.sebka.scenes.GameScene;

public class World2 extends GameScene {

	public World2(){
		MouseHandler.setCursor(ImageLoader.load("/images/gui/cursor.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/3/map.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/3/top.png"));
		mobspawner.setMobs(MapLoader.loadMobs("/images/maps/3/mobs.txt"));
		
	}
	
}
