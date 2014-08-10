package nu.sebka.scenes;




import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

import nu.sebka.instances.House;
import nu.sebka.instances.MobSpawner;
import nu.sebka.instances.turrets.Turret;
import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.MouseHandler;
import nu.sebka.main.Scene;
import nu.sebka.main.Terminal;
import nu.sebka.scenes.worlds.World0;

public class GameScene extends Scene {
	public House house;
	public MobSpawner mobspawner;
	public int startTimer = 2060;
	int mobs = 0;
	boolean count = true;


	public void defaultTick(){
		
		if(Game.keys[KeyEvent.VK_R]){
			Game.scenes.set(Game.sceneIndex, new LoadingScene(0){

				@Override
				public void onDone() {
					try {
						Scene scene = Game.getCurrentScene().getClass().newInstance();
						Game.scenes.set(Game.sceneIndex,scene);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}});
		}
		
		if(count && mobspawner != null){
			mobs = mobspawner.mobs.size();
			count = false;
		}

		if(Game.keys[KeyEvent.VK_CONTROL]){
			if(Terminal.isOpen()){
				Terminal.close();
			}else{
				Terminal.open();
			}
			Game.keys[KeyEvent.VK_CONTROL] = false;
		}

		if(!Terminal.isOpen()){
			if(startTimer > 0){
				startTimer -= 1;
			}else{
				mobspawner.canSpawn = true;
			}
		}
		
		if(Game.kills >= mobs){
			
			Game.scenes.set(Game.sceneIndex, new LoadingScene(16){

				@Override
				public void onDone() {
					
					Game.kills = 0;
					
					if(Game.scenes.size() > Game.sceneIndex+1){
					Game.sceneIndex += 1;
					}else{
						Game.sceneIndex = 0;
					}
					
				}});
			
			
		}
	}


	public void drawGUI(Graphics2D g2d){

		if(!Terminal.isOpen()){
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
			g2d.setColor(Color.black);
			g2d.fillRect(0, 0, 100, 86);

			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

			g2d.drawImage(ImageLoader.load("/images/gui/money.png"), 0, 0, null);
			g2d.drawImage(ImageLoader.load("/images/gui/clock.png"),0,32,null);

			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font(Font.SERIF,14,14));
			g2d.drawString(Game.money+"", 34, 25);
			g2d.drawString(startTimer/60+"", 34, 56);
			g2d.drawString(Game.kills+" / "+mobs, 14, 78);







			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
			g2d.setColor(Color.black);
			g2d.fillRect(0, Game.RENDERSIZE.height-60, 190, 32);

			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font(Font.SERIF,14,14));
			g2d.drawString("Press 'CTRL' to open terminal.", 4, Game.RENDERSIZE.height-36);





		}


		if(Game.boughtObject != null){
			if(Game.boughtObject instanceof Turret){
				Turret turret = (Turret) Game.boughtObject;
				g2d.drawImage(turret.head.getCurrentImage(), MouseHandler.getMousePosition().x, MouseHandler.getMousePosition().y, null);
			}else{
				g2d.drawImage(Game.boughtObject.sprite.getCurrentImage(), MouseHandler.getMousePosition().x, MouseHandler.getMousePosition().y, null);
			}
		}
	}

}
