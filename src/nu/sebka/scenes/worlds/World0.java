package nu.sebka.scenes.worlds;

import nu.sebka.main.ImageLoader;
import nu.sebka.main.MapLoader;
import nu.sebka.main.MouseHandler;
import nu.sebka.scenes.GameScene;

public class World0 extends GameScene {

	public World0(){
		MouseHandler.setCursor(ImageLoader.load("/images/gui/cursor.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/1/map.png"));
		MapLoader.loadMap(this, ImageLoader.load("/images/maps/1/top.png"));
	}
	
}
