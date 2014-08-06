package nu.sebka.instances;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

import nu.sebka.main.Game;
import nu.sebka.main.Instance;

public class Mob extends Entity {


	ArrayList<PathPoint> points = new ArrayList<PathPoint>();
	boolean getPoints = true;

	public Mob(double x, double y) {
		super(x, y);

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

			if(x < getNearestPoint().x+16){
				x += 1;
			}
			if(x > getNearestPoint().x+16){
				x -= 1;
			}
			if(y < getNearestPoint().y+16){
				y += 1;
			}
			if(y > getNearestPoint().y+16){
				y -= 1;
			}

			if(x >= getNearestPoint().x && x <= getNearestPoint().x+32 && y >= getNearestPoint().y && y <= getNearestPoint().y+32 ){
				points.remove(getNearestPoint());
			}

		}
	}

	public void draw(Graphics2D g2d){
		drawSprite(g2d,sprite.getCurrentImage());
		
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
