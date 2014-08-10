package nu.sebka.scenes;

import java.awt.Graphics2D;

import nu.sebka.main.Game;
import nu.sebka.main.GameButton;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.Scene;
import nu.sebka.scenes.worlds.World0;

public class MenuScene extends Scene {

	GameButton startbutton;
	GameButton exitbutton;
	
	public MenuScene(){
		startbutton = new GameButton(Game.RENDERSIZE.width/2-(194/2),120,ImageLoader.load("/images/gui/button.png"),"Start Game"){

			@Override
			public void onPress() {
				Game.scenes.set(1, new LoadingScene(0){

					@Override
					public void onDone() {
						Game.scenes.set(1, new World0());
						
					}});
				Game.sceneIndex += 1;
				
			}};
			
		exitbutton = new GameButton(Game.RENDERSIZE.width/2-(194/2),120+86,ImageLoader.load("/images/gui/button.png"),"Exit"){

			@Override
			public void onPress() {
				System.exit(0);
				
			}};
	}
	
	public void tick(){
		
		startbutton.tick();
		exitbutton.tick();
		
	}
	
	public void draw(Graphics2D g2d){
		startbutton.draw(g2d);
		exitbutton.draw(g2d);
	}
	
}
