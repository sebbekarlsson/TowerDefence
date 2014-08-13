package nu.sebka.instances.tiles;



import java.util.Random;

import nu.sebka.instances.Tile;
import nu.sebka.main.ImageLoader;


public class StoneTile extends Tile {

	
	Random random = new Random();
	public StoneTile(double x, double y) {
		super(x, y);
		
		if(random.nextInt(10) == 0){
			sprite.images.add(ImageLoader.load("/images/patternstone.png"));
		}else{
			
			sprite.images.add(ImageLoader.load("/images/crackedstone.png"));
		}
		
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
