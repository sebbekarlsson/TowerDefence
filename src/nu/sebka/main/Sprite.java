package nu.sebka.main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sprite {

	public ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	public int imageindex = 0;
	
	public BufferedImage getCurrentImage(){
		return images.get(imageindex);
	}
}
