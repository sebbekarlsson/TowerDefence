package nu.sebka.instances.tiles;

import java.awt.Graphics2D;

import nu.sebka.instances.Tile;
import nu.sebka.main.ImageLoader;


public class DirtTile extends Tile {

	public DirtTile(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/dirt.png"));
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	public void draw(Graphics2D g2d){
		drawSprite(g2d,sprite.getCurrentImage());
		drawHooverEffect(g2d);
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
