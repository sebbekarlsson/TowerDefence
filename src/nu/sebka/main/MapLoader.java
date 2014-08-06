package nu.sebka.main;

import java.awt.Color;
import java.awt.image.BufferedImage;

import nu.sebka.instances.MobSpawner;
import nu.sebka.instances.PathPoint;
import nu.sebka.instances.tiles.DirtTile;
import nu.sebka.instances.tiles.GrassTile;

public class MapLoader {

	public static void loadMap(Scene scene, BufferedImage image){
		for(int x = 0; x < image.getWidth(); x++){
			for(int y = 0; y < image.getHeight(); y++){
				Color color = new Color(image.getRGB(x, y));

				int r = color.getRed();
				int g = color.getGreen();
				int b = color.getBlue();
				
				//System.out.println(r+" "+g+" "+b);
				
				if(r == 0 && g == 128 && b == 0){
					scene.createInstance(new GrassTile(x*32,y*32));
				}
				else if(r == 128 && g == 70 && b == 20){
					scene.createInstance(new DirtTile(x*32,y*32));
				}
				else if(r == 160 && g == 0 && b == 120){
					scene.createInstance(new MobSpawner(x*32,y*32));
				}
				else if(r == 255 && g == 255 && b == 0){
					scene.createInstance(new PathPoint(x*32,y*32));
				}
				
			}
		}
	}
	
}
