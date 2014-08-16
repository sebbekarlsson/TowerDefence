package nu.sebka.instances.turrets;



import nu.sebka.main.ImageLoader;

public class FireTurret extends Turret {

	
	
	public FireTurret(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/turrets/fireturret/head.png"));
		
	}
	
	

}
