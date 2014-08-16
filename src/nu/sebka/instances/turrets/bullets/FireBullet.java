package nu.sebka.instances.turrets.bullets;



import java.util.Random;

import nu.sebka.instances.entities.Bullet;
import nu.sebka.instances.entities.FireParticle;
import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;

public class FireBullet extends Bullet {

	Random random = new Random();
	public FireBullet(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/turrets/fireturret/bullet.png"));
		damage = 45;
	}
	
	public void tick(){
		if(random.nextInt(3) == 0){
			for(int i = 0; i < random.nextInt(18); i++){
				FireParticle particle = new FireParticle(x,y);
				particle.speed = random.nextInt(2)+1;
				particle.direction = random.nextInt(360);
				particle.health = random.nextInt(10)+1;
				Game.getCurrentScene().createInstance(particle);
			}
		}
	}
	
	

}
