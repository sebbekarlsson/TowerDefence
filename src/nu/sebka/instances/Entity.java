package nu.sebka.instances;

import nu.sebka.main.Instance;


public abstract class Entity extends Instance {

	public double speed = 2.5;
	public float direction = 0;
	public double health = 100;
	
	public Entity(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
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
	
	public void moveInDirection(float dir,double speed){
		x += (Math.cos(Math.toRadians(dir)) * speed);
		y += (Math.sin(Math.toRadians(dir)) * speed);
		
		direction = dir;
	}
	
	public void lookAt(double xx, double yy){
		
		
		float rot = (float)Math.atan2(yy - y,xx - x);
		direction = (float)Math.toDegrees(rot);
		
	}
	
	
	public void lookAtInstance(Instance instance){
		
		
		float rot = (float)Math.atan2((instance.y + instance.sprite.getCurrentImage().getHeight()/2) - y,(instance.x + instance.sprite.getCurrentImage().getWidth() / 2) - x);
		direction = (float)Math.toDegrees(rot);
		
	}

}
