package nu.sebka.instances.turrets;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import nu.sebka.instances.Entity;
import nu.sebka.instances.entities.Bullet;
import nu.sebka.instances.entities.Mob;
import nu.sebka.instances.turrets.bullets.BlasterBullet;
import nu.sebka.instances.turrets.bullets.FireBullet;
import nu.sebka.instances.turrets.bullets.LaserBullet;
import nu.sebka.instances.turrets.bullets.MachineBullet;
import nu.sebka.instances.turrets.bullets.WaterBullet;
import nu.sebka.main.Game;
import nu.sebka.main.Instance;



public abstract class Turret extends Entity {

	
	protected Random random = new Random();
	public int radius = 128;
	public int SHOOT_TIME = 10;
	int shootTimer = SHOOT_TIME;
	//public Sprite flash = new Sprite();
	public boolean isShooting = false;
	//public int animeTimer = 5;


	public Turret(double x, double y) {
		super(x, y);
		//flash.images.add(ImageLoader.getFrames("/images/flash.gif").get(0));
	}






	public void draw(Graphics2D g2d){
		
		
		
		if(isMouseOver()){
			g2d.setColor(new Color(150,220,230));
			
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
			
			g2d.fillOval((int)x-(radius/2)+sprite.getCurrentImage().getWidth()/2, (int)y-(radius/2)+sprite.getCurrentImage().getHeight()/2, radius, radius);
			
			g2d.setColor(Color.BLACK);
			
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
			
			g2d.drawOval((int)x-(radius/2)+sprite.getCurrentImage().getWidth()/2, (int)y-(radius/2)+sprite.getCurrentImage().getHeight()/2, radius, radius);
		}
		
		drawRotatedSprite(g2d,sprite.getCurrentImage(),x,y,direction);
		if(isShooting){
			
			//if(animeTimer > 0){
				//animeTimer -= 1;
				
			//}else{
				//drawRotatedSprite(g2d,flash.getCurrentImage(),x,y,direction);
				//animeTimer = 5;
			//}
			
		}


		
			
		
	}

	@Override
	public void tick() {



	}

	@Override
	public void defaultTick() {

		
		
		
		Mob m = getMobInRadius(radius);
		if(m != null){
			lookAtInstance(m);
				if(shootTimer > 0){
					shootTimer -= 1;
					
				}else{
					isShooting = true;
					shoot(direction,7);
					shootTimer = SHOOT_TIME;
				}
				
			
		}else{
			isShooting = false;
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
		else if(this instanceof BlasterTurret){
			bullet = new BlasterBullet(x,y);
		}
		else if(this instanceof MachineTurret){
			bullet = new MachineBullet(x,y);
		}
		else if(this instanceof FireTurret){
			bullet = new FireBullet(x,y);
		}

		bullet.direction = dir;
		bullet.speed = speed;

		Game.getCurrentScene().createInstance(bullet);


	}

}
