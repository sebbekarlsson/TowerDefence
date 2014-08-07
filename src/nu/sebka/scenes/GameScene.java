package nu.sebka.scenes;




import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import nu.sebka.instances.House;
import nu.sebka.instances.MobSpawner;
import nu.sebka.main.Game;
import nu.sebka.main.ImageLoader;
import nu.sebka.main.Scene;

public class GameScene extends Scene {
	public House house;
	public MobSpawner mobspawner;
	
	public void drawGUI(Graphics2D g2d){
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, 100, 32);
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		
		g2d.drawImage(ImageLoader.load("/images/gui/money.png"), 0, 0, null);
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SERIF,14,14));
		g2d.drawString(Game.money+"", 34, 25);
		
		
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
		g2d.setColor(Color.black);
		g2d.fillRect(0, Game.RENDERSIZE.height-60, 150, 32);
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SERIF,14,14));
		g2d.drawString("Press 'S' to open shop.", 4, Game.RENDERSIZE.height-36);
	}
	
}
