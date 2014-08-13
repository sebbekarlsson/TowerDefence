package nu.sebka.instances.tiles;

import nu.sebka.instances.Tile;
import nu.sebka.main.ImageLoader;

public class BuildTile extends Tile {

	public BuildTile(double x, double y) {
		super(x, y);
		canBuild = true;
		sprite.images.add(ImageLoader.load("/images/buildtile.png"));
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
