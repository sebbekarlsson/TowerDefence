package nu.sebka.main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import nu.sebka.instances.House;
import nu.sebka.instances.MobSpawner;
import nu.sebka.instances.PathPoint;
import nu.sebka.instances.entities.Mob;
import nu.sebka.instances.mobs.ShipMob;
import nu.sebka.instances.mobs.SpiderMob;
import nu.sebka.instances.mobs.ZombieMob;
import nu.sebka.instances.tiles.BuildTile;
import nu.sebka.instances.tiles.StoneTile;
import nu.sebka.scenes.GameScene;

public class MapLoader {

	public static void loadMap(GameScene scene, BufferedImage image){
		
		for(int x = 0; x < image.getWidth(); x++){
			for(int y = 0; y < image.getHeight(); y++){
				Color color = new Color(image.getRGB(x, y));

				int r = color.getRed();
				int g = color.getGreen();
				int b = color.getBlue();
			
				if(r == 140 && g == 140 && b == 140){
					scene.createInstance(new StoneTile(x*32,y*32));
				}
				else if(r == 80 && g == 190 && b == 200){
					scene.createInstance(new BuildTile(x*32,y*32));
				}
				else if(r == 160 && g == 0 && b == 120){
					MobSpawner ms = new MobSpawner(x*32,y*32);
					scene.mobspawner = ms;
					scene.createInstance(ms);
				}
				else if(r == 255 && g == 255 && b == 0){
					scene.createInstance(new PathPoint(x*32,y*32));
				}
				else if(r == 255 && g == 190 && b == 0){
					House h = new House(x*32,y*32);
					scene.house = h;
					scene.createInstance(new House(x*32,y*32));
				}
				
			}
		}
		
		
	}
	
	public static ArrayList<Mob> loadMobs(String file){
		ArrayList<Mob> mobs = new ArrayList<Mob>();
		try{
		BufferedReader br = new BufferedReader(new InputStreamReader(MapLoader.class.getResourceAsStream(file)));
		String line;
		while ((line = br.readLine()) != null) {
		   if(line.equalsIgnoreCase("zombie")){
			   mobs.add(new ZombieMob(0,0));
		   }
		   else if(line.equalsIgnoreCase("spider")){
			   mobs.add(new SpiderMob(0,0));
		   }
		   else if(line.equalsIgnoreCase("ship")){
			   mobs.add(new ShipMob(0,0));
		   }
		   
		}
		br.close();
		return mobs;
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
}
