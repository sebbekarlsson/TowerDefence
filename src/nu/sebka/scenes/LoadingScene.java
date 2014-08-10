package nu.sebka.scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import nu.sebka.main.Game;
import nu.sebka.main.Scene;

public abstract class LoadingScene extends Scene {

	int timer = 60;
	
	public LoadingScene(int loadingTime){
		timer = loadingTime;
	}
	
	public abstract void onDone();
	
	
	public void tick(){
		if(timer > 0){
			timer -= 1;
		}else{
			onDone();
		}
	}
	
	public void draw(Graphics2D g2d){
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SERIF,52,52));
		g2d.drawString("Loading...", Game.RENDERSIZE.width/2-("Loading...".length()*9), Game.RENDERSIZE.height/2);
	}
	
	
}
