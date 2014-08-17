package nu.sebka.main.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import nu.sebka.main.Game;

public class LoadingScreen extends GUIObject {

	int timer = 60;
	int b = 52;
	
	public LoadingScreen(int loadingTime){
		timer = loadingTime;
	}
	
	
	
	
	public void tick(){
		if(timer > 0){
			timer -= 1;
		}else{
			Game.getCurrentScene().destroyGUIObject(this);
		}
		
	}
	
	public void draw(Graphics2D g2d){
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, Game.RENDERSIZE.width, Game.RENDERSIZE.height);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SERIF,52,52));
		g2d.drawString("Loading...", Game.RENDERSIZE.width/2-("Loading...".length()*9), Game.RENDERSIZE.height/2);
		
	}
	
	
}
