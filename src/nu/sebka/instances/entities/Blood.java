package nu.sebka.instances.entities;

import nu.sebka.instances.Entity;
import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;

public class Blood extends Entity {

	float timer = 360;
	public Blood(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/blood.png"));
	}
	
	public void defaultTick(){
		if(timer > 0){
			timer -= 1;
		}else{
			Game.getCurrentScene().destroyInstance(this);
		}
	}

}
