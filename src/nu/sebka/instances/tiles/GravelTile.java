package nu.sebka.instances.tiles;

import nu.sebka.instances.Tile;
import nu.sebka.main.ImageLoader;

public class GravelTile extends Tile{

	public GravelTile(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/gravel.png"));
	}

	@Override
	public void tick() {
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
