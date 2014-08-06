package nu.sebka.instances;

import java.awt.Graphics2D;

import nu.sebka.main.ImageLoader;
import nu.sebka.main.Instance;

public class PathPoint extends Instance {

	
	
	public PathPoint(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/point.png"));
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	public void draw(Graphics2D g2d){
		
	}

	@Override
	public void defaultTick() {
		// TODO Auto-generated method stub
		
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

}
