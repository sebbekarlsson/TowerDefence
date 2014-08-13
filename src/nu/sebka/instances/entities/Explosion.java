package nu.sebka.instances.entities;

import java.awt.Graphics2D;

import nu.sebka.instances.Entity;
import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;

public class Explosion extends Entity {

	
	int animeTime = 5;
	
	public Explosion(double x, double y) {
		super(x, y);
		sprite.images = ImageLoader.getFrames("/images/explosion.gif");
	}
	
	public void defaultTick(){
		if(animeTime > 0){
			animeTime -= 1;
		}else{
			animeTime = 1;
			if(sprite.imageindex < sprite.images.size()-1){
				sprite.imageindex += 1;
			}else{
				Game.getCurrentScene().destroyInstance(this);
				sprite.imageindex = 0;
			}
		}
	}
	
	public void draw(Graphics2D g2d){
		drawScaledSprite(g2d,sprite.getCurrentImage(),x,y,64,64);
	}

}
