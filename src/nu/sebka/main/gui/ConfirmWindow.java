package nu.sebka.main.gui;

import java.awt.Graphics2D;

import nu.sebka.main.Game;
import nu.sebka.main.GameButton;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.Sprite;

public class ConfirmWindow extends GUIObject {

	GameButton okbutton;
	Sprite window = new Sprite();
	GUIObject object = this;
	
	public String text = "";
	
	public ConfirmWindow(String text){
		this.text = text;
		window.images.add(ImageLoader.load("/images/gui/shopframe.png"));
		x = (Game.RENDERSIZE.width / 2) - window.getCurrentImage().getWidth() / 2;
		y = (Game.RENDERSIZE.height / 2) - window.getCurrentImage().getHeight() / 2;
		
		okbutton = new GameButton(x+(window.getCurrentImage().getWidth()/2)-97,y+window.getCurrentImage().getHeight()-64,ImageLoader.load("/images/gui/button.png"),"Ok"){

			@Override
			public void onPress() {
				
				
				Game.getCurrentScene().destroyGUIObject(object);
				
				
			}};
	}
	
	@Override
	public void tick() {
		okbutton.tick();
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
			g2d.drawImage(ImageLoader.load("/images/gui/shopframe.png"), (int)x, (int)y, null);
			okbutton.draw(g2d);
			g2d.drawString(text, (int)x+window.getCurrentImage().getWidth()/2-(text.length()*3), (int)y+120);
		
		
	}

}
