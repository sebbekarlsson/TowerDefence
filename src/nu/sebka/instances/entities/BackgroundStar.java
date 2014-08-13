package nu.sebka.instances.entities;




import java.util.Random;

import nu.sebka.instances.Entity;
import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;


public class BackgroundStar extends Entity {



	Random random = new Random();
	

	public BackgroundStar(double x, double y) {
		super(x, y);
		//sprite.images.add(ImageLoader.load("/images/star.png"));
		
		sprite.images.add(ImageLoader.load("/images/star.png"));
		

		speed = 0.3;
	}

	public void defaultTick(){

		

		if(isOutsideRoom()){
			x = random.nextInt(Game.getCurrentScene().WIDTH);
			y = random.nextInt(Game.getCurrentScene().HEIGHT);
		}

		moveInDirection(120,speed);
	}

}
