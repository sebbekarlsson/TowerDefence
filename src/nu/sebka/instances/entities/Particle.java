package nu.sebka.instances.entities;

import nu.sebka.instances.Entity;
import nu.sebka.main.Game;

public class Particle extends Entity {



	public Particle(double x, double y) {
		super(x, y);

	}

	public void defaultTick(){
		moveInDirection(direction,speed);

		if(speed > 0){
			speed -= 0.1;
		}
		health -= 0.5;


		if(health < 1){
			Game.getCurrentScene().destroyInstance(this);
		}

		if(isOutsideRoom()){
			Game.getCurrentScene().destroyInstance(this);
		}
	}


}
