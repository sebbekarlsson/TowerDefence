package nu.sebka.main.gui;

import java.awt.Color;
import java.awt.Graphics2D;

import nu.sebka.instances.turrets.BlasterTurret;
import nu.sebka.instances.turrets.LaserTurret;
import nu.sebka.instances.turrets.MachineTurret;
import nu.sebka.instances.turrets.WaterTurret;
import nu.sebka.main.Game;
import nu.sebka.main.GameButton;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.PriceList;
import nu.sebka.main.Sprite;

public class ShopWindow extends GUIObject {

	Sprite sprite = new Sprite();
	boolean isOpen = false;

	GameButton blasterturretbutton;
	GameButton laserturretbutton;
	GameButton waterturretbutton;
	GameButton machineturretbutton;
	
	

	public ShopWindow(){
		
		
		
		sprite.images.add(ImageLoader.load("/images/gui/shopframe.png"));

		x =( Game.RENDERSIZE.width / 2) - sprite.getCurrentImage().getWidth()/2;
		y =( Game.RENDERSIZE.height / 2) - sprite.getCurrentImage().getHeight()/2;

		blasterturretbutton = new GameButton(x+64, y+92, ImageLoader.load("/images/gui/button_small.png"), "Buy "+PriceList.blasterturret){

			@Override
			public void onPress() {
				
				if(Game.money >= PriceList.blasterturret){
					Game.boughtObject = new BlasterTurret(0,0);
					Game.money -= PriceList.blasterturret;
					close();
					
				}else{
					close();
					Game.getCurrentScene().guiobjects.add(new ConfirmWindow("Not enough money"));
					
				}

			}

		};
		
		
		laserturretbutton = new GameButton(x+64, y+184, ImageLoader.load("/images/gui/button_small.png"), "Buy "+PriceList.laserturret){

			@Override
			public void onPress() {
				
				if(Game.money >= PriceList.laserturret){
					Game.boughtObject = new LaserTurret(0,0);
					Game.money -= PriceList.laserturret;
					close();
				}else{
					close();
					Game.getCurrentScene().guiobjects.add(new ConfirmWindow("Not enough money"));
				}

			}

		};
		
		
		waterturretbutton = new GameButton(x+64, y+276, ImageLoader.load("/images/gui/button_small.png"), "Buy "+PriceList.waterturret){

			@Override
			public void onPress() {
				
				if(Game.money >= PriceList.waterturret){
					Game.boughtObject = new WaterTurret(0,0);
					Game.money -= PriceList.waterturret;
					close();
				}else{
					close();
					Game.getCurrentScene().guiobjects.add(new ConfirmWindow("Not enough money"));
				}

			}

		};
		
		
		machineturretbutton = new GameButton(x+160, y+92, ImageLoader.load("/images/gui/button_small.png"), "Buy "+PriceList.machineturret){

			@Override
			public void onPress() {
				
				if(Game.money >= PriceList.machineturret){
					Game.boughtObject = new MachineTurret(0,0);
					Game.money -= PriceList.machineturret;
					close();
				}else{
					close();
					Game.getCurrentScene().guiobjects.add(new ConfirmWindow("Not enough money"));
				}

			}

		};

	}

	@Override
	public void tick() {
		if(isOpen){
			blasterturretbutton.tick();
			laserturretbutton.tick();
			waterturretbutton.tick();
			machineturretbutton.tick();
		}
		
		

	}

	@Override
	public void draw(Graphics2D g2d) {
		
		
		
		if(isOpen){
			g2d.drawImage(sprite.getCurrentImage(), (int)x, (int)y, null);
			
			g2d.setColor(Color.WHITE);
			
			blasterturretbutton.draw(g2d);
			g2d.drawImage(ImageLoader.load("/images/turrets/blasterturret/head.png"), (int)x+86, (int)y+64, null);
			g2d.drawString("Blaster Turret", (int)x+64, (int)y+64);
			
			laserturretbutton.draw(g2d);
			g2d.drawImage(ImageLoader.load("/images/turrets/laserturret/head.png"), (int)x+86, (int)y+160, null);
			g2d.drawString("Laser Turret", (int)x+64, (int)y+160);
			
			waterturretbutton.draw(g2d);
			g2d.drawImage(ImageLoader.load("/images/turrets/waterturret/head.png"), (int)x+86, (int)y+240, null);
			g2d.drawString("Water Turret", (int)x+64, (int)y+240);
			
			
			
			machineturretbutton.draw(g2d);
			g2d.drawImage(ImageLoader.load("/images/turrets/machineturret/head.png"), (int)x+172, (int)y+64, null);
			g2d.drawString("Machine Turret", (int)x+160, (int)y+64);
		}
		
		

	}

	public void close(){
		isOpen = false;
	}

	public void open(){
		isOpen = true;
	}

	public boolean isOpen(){
		return isOpen;
	}


}
