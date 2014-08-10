package nu.sebka.instances;

import nu.sebka.main.ImageLoader;
import nu.sebka.main.Instance;

public class Tree extends Instance {

	public Tree(double x, double y) {
		super(x, y);
		sprite.images.add(ImageLoader.load("/images/tree.png"));
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

}
