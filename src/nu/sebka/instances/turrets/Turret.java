package nu.sebka.instances.turrets;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import nu.sebka.instances.Bullet;
import nu.sebka.instances.Entity;
import nu.sebka.instances.Mob;
import nu.sebka.main.Game;
import nu.sebka.main.Instance;
import nu.sebka.main.Sprite;

public abstract class Turret extends Entity {

	public Sprite head = new Sprite();
	protected Random random = new Random();


	public Turret(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	
	

	
	
	public void draw(Graphics2D g2d){
		drawRotatedSprite(g2d,head.getCurrentImage(),direction);
	}
	
	@Override
	public void tick() {



	}

	@Override
	public void defaultTick() {

		Mob m = getMobInRadius(128);
		if(m != null){
			lookAt(m.x,m.y);
			if(random.nextInt(3) == 0){
				shoot(direction,7);
			}
		}
		


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

	public Mob getNearestMob(){
		ArrayList<Mob> mobs = new ArrayList<Mob>();
		for(int i = 0; i < Game.getCurrentScene().instances.size(); i++){
			Instance instance = Game.getCurrentScene().instances.get(i);
			if(instance instanceof Mob){
				Mob mob = (Mob) instance;
				mobs.add(mob);
			}
		}
		double[] distances = new double[mobs.size()];
		for(int i = 0; i < distances.length; i++){
			Mob m = mobs.get(i);
			distances[i] = Math.sqrt((x-m.x)*(x-m.x) + (y-m.y)*(y-m.y));
		}

		Arrays.sort(distances);

		for(int i = 0; i < mobs.size(); i++){
			Mob m = mobs.get(i);
			if(Math.sqrt((x-m.x)*(x-m.x) + (y-m.y)*(y-m.y)) == distances[i]){
				return m;
			}
		}

		return null;
	}


	public Mob getMobInRadius(float r){
		ArrayList<Mob> mobs = new ArrayList<Mob>();
		for(int i = 0; i < Game.getCurrentScene().instances.size(); i++){
			Instance instance = Game.getCurrentScene().instances.get(i);
			if(instance instanceof Mob){
				Mob mob = (Mob) instance;
				mobs.add(mob);
			}
		}

		for(int i = 0; i < mobs.size(); i++){
			Mob m = mobs.get(i);
			if (Math.sqrt((x-m.x)*(x-m.x) + (y-m.y)*(y-m.y)) < r){
				return m;
			}
		}

		return null;
	}

	public void shoot(float dir,double speed){



		Bullet bullet = null;

		if(this instanceof LaserTurret){
			bullet = new LaserBullet(x,y);
		}
		else if(this instanceof WaterTurret){
			bullet = new WaterBullet(x,y);
		}

		bullet.direction = dir;
		bullet.speed = speed;

		Game.getCurrentScene().createInstance(bullet);


	}

}
