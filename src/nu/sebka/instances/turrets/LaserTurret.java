package nu.sebka.instances.turrets;



import nu.sebka.main.ImageLoader;

public class LaserTurret extends Turret {

	
	
	public LaserTurret(double x, double y) {
		super(x, y);
		head.images.add(ImageLoader.load("/images/turrets/laserturret/head.png"));
		
	}
	
	

}
