package nu.sebka.instances.entities;

import java.awt.Graphics2D;

import nu.sebka.instances.Entity;
import nu.sebka.main.Game;

public class Bullet extends Entity {
	
	public double damage = 11;

	public Bullet(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void defaultTick(){
		moveInDirection(direction, speed);
		
		if(isOutsideRoom()){
			
			Game.getCurrentScene().destroyInstance(this);
		}
	}
	
	public void draw(Graphics2D g2d){
		drawRotatedSprite(g2d,sprite.getCurrentImage(),x,y,direction);
	}

}
