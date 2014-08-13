package nu.sebka.instances.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import nu.sebka.instances.Entity;
import nu.sebka.instances.House;
import nu.sebka.instances.PathPoint;
import nu.sebka.instances.turrets.bullets.BlasterBullet;
import nu.sebka.instances.turrets.bullets.MachineBullet;
import nu.sebka.main.Game;
import nu.sebka.main.Instance;

public class Mob extends Entity {




	ArrayList<PathPoint> points = new ArrayList<PathPoint>();
	PathPoint nearestPoint = null;
	boolean getPoints = true;

	public double protection = 10;
	public int moneyGain = 10;

	double imgdir = 0;
	Random random = new Random();





	public Mob(double x, double y) {
		super(x, y);
		health = 100;
	}

	public void onDestroy(){

	}

	public void defaultTick(){

		if(getPoints){
			for(int i = 0; i < Game.getCurrentScene().instances.size(); i++){
				Instance instance = Game.getCurrentScene().instances.get(i);
				if(instance instanceof PathPoint){
					PathPoint p = (PathPoint) instance;
					points.add(p);
				}

			}

			getPoints = false;
		}



		if(points.size() > 0){

			if(nearestPoint == null){
				nearestPoint = getNearestPoint();
				nearestPoint.marked = true;
			}

			if(x+32 < nearestPoint.x+32){
				//moveInDirection(0,speed);
				if(direction > 0){
					direction -= 5;
				}else if(direction < 0){
					direction += 5;
				}

				moveInDirection(0,speed);
			}
			else if(x-32 > nearestPoint.x){
				//moveInDirection(180,speed);
				if(direction > 180){
					direction -= 5;
				}else if(direction < 180){
					direction += 5;
				}

				moveInDirection(180,speed);
			}
			else if(y+32 < nearestPoint.y+32){
				//moveInDirection(90,speed);
				if(direction > 90){
					direction -= 5;
				}else if(direction < 90){
					direction += 5;
				}

				moveInDirection(90,speed);
			}
			else if(y-32 > nearestPoint.y){
				//moveInDirection(270,speed);
				if(direction > 270){
					direction -= 5;
				}else if(direction < 270){
					direction += 5;
				}

				moveInDirection(270,speed);
			}



			if(x+16 >= nearestPoint.x && x <= nearestPoint.x+32 && y+16 >= nearestPoint.y && y <= nearestPoint.y+32 ){
				nearestPoint.marked = false;
				points.remove(nearestPoint);
				nearestPoint = null;
			}




		}else{
			House.health -= 10;
			Game.getCurrentScene().destroyInstance(this);
		}


		for(int i = 0; i < Game.getCurrentScene().instances.size(); i++){
			Instance instance = Game.getCurrentScene().instances.get(i);
			if (instance instanceof Bullet){

				Bullet b = (Bullet) instance;
				if(b.x >= x && b.x <= x+sprite.getCurrentImage().getWidth() && b.y >= y && b.y <= y+sprite.getCurrentImage().getHeight()){

					if(protection < 1){
						health -= b.damage;
					}
					if(protection > 0){
						protection -= (1+(b.damage/2));
					}

					if(protection < 0){
						protection = 0;
					}

					if(b instanceof BlasterBullet){
						Game.getCurrentScene().createInstance(new Explosion(x,y));
					}
					else if(b instanceof MachineBullet){
						for(int ii = 0; ii < 16; ii++){

							RicoParticle particle = new RicoParticle(x,y);
							particle.direction = random.nextInt(360);

							Game.getCurrentScene().createInstance(particle);

						}
					}

					Game.getCurrentScene().destroyInstance(b);
				}
			}
		}

		if(health < 1){
			Game.money += moneyGain;
			Game.kills += 1;
			TextLabelObject tlo = new TextLabelObject(x,y,"+"+moneyGain);
			tlo.willDestroy = true;
			tlo.color = Color.YELLOW;
			Game.getCurrentScene().createInstance(tlo);
			die();
		}



	}

	public void draw(Graphics2D g2d){
		if(imgdir < direction){
			imgdir += 5;
		}else if(imgdir > direction){
			imgdir -= 5;
		}
		drawRotatedSprite(g2d,sprite.getCurrentImage(),x,y,imgdir);


		g2d.setColor(Color.black);
		g2d.fillRect((int)x-4, (int)y-52, 32, 32);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SERIF,14,14));
		g2d.drawString((int)health+"", (int)x-4, (int)y-37);
		g2d.setColor(Color.blue);
		g2d.drawString((int)protection+"", (int)x-4, (int)y-24);


	}

	public void die(){
		Game.getCurrentScene().destroyInstance(this);
	}

	PathPoint getNearestPoint(){
		double[] distances = new double[points.size()];

		for(int i = 0; i < points.size(); i++){
			PathPoint p = points.get(i);
			distances[i] = Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y));
		}

		Arrays.sort(distances);

		for(int i = 0; i < points.size(); i++){
			PathPoint p = points.get(i);
			if (Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y)) == distances[0]){

				return p;
			}
		}



		return null;
	}

}
