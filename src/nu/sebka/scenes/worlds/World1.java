package nu.sebka.scenes.worlds;




import nu.sebka.main.ImageLoader;
import nu.sebka.main.MapLoader;
import nu.sebka.main.MouseHandler;
import nu.sebka.scenes.GameScene;

public class World1 extends GameScene {

	public void init(){
		createStars(32);
		MouseHandler.setCursor(ImageLoader.load("/images/gui/cursor.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/2/map.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/2/top.png"));
		mobspawner.setMobs(MapLoader.loadMobs("/images/maps/2/mobs.txt"));
		
	}
	
}
