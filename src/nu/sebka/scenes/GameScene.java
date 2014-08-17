package nu.sebka.scenes;




import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Random;

import nu.sebka.instances.House;
import nu.sebka.instances.MobSpawner;
import nu.sebka.instances.entities.BackgroundStar;
import nu.sebka.instances.turrets.Turret;
import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.MouseHandler;
import nu.sebka.main.Scene;
import nu.sebka.main.Terminal;
import nu.sebka.main.gui.LoadingScreen;
import nu.sebka.main.gui.ShopWindow;


public class GameScene extends Scene {
	public House house;
	public MobSpawner mobspawner;
	public int startTimer = 2060;
	int mobs = 0;
	boolean count = true;
	boolean init = true;

	protected Random random = new Random();

	public static ShopWindow shopwindow = new ShopWindow();

	public void init(){}



	public void defaultTick(){

		if(shopwindow.isOpen()){
			shopwindow.tick();
		}

		if(init){
			Game.getCurrentScene().guiobjects.add(new LoadingScreen(0));
			init();
			init = false;
		}



		if(!Terminal.isOpen()){

			if(Game.keys[KeyEvent.VK_R]){




				Game.kills = 0;
				Game.money = Game.DEFAULT_MONEY;
				House.health = 100;
				Game.sceneIndex = 0;



			}

			if(count && mobspawner != null){

				House.health = 100;
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


				if(Game.keys[KeyEvent.VK_B]){
					if(shopwindow.isOpen()){
						shopwindow.close();
					}
					else if(!shopwindow.isOpen()){
						shopwindow.open();
					}

					Game.keys[KeyEvent.VK_B] = false;
				}
			}



			if(Game.kills >= mobs){





				Game.kills = 0;

				if(Game.scenes.size() > Game.sceneIndex+1){
					Game.sceneIndex += 1;
				}else{
					Game.sceneIndex = 0;
				}

			}
		}



	}


	public void drawGUI(Graphics2D g2d){

		if(shopwindow.isOpen()){
			shopwindow.draw(g2d);
		}

		if(!Terminal.isOpen() && !shopwindow.isOpen()){
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
			g2d.drawString("Press 'B' to open the shop.", 4, Game.RENDERSIZE.height-36);





		}




		if(Game.boughtObject != null){
			if(Game.boughtObject instanceof Turret){
				Turret turret = (Turret) Game.boughtObject;
				g2d.drawImage(turret.sprite.getCurrentImage(), MouseHandler.getMousePosition().x, MouseHandler.getMousePosition().y, null);
			}else{
				g2d.drawImage(Game.boughtObject.sprite.getCurrentImage(), MouseHandler.getMousePosition().x, MouseHandler.getMousePosition().y, null);
			}
		}
	}


	public void createStars(int stars){

		for(int i = 0; i < stars; i++){

			BackgroundStar star = new BackgroundStar(random.nextInt(WIDTH),random.nextInt(HEIGHT));
			instances.add(0, star);
		}
	}

}
