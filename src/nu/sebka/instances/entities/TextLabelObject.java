package nu.sebka.instances.entities;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import nu.sebka.instances.Entity;
import nu.sebka.main.Game;

public class TextLabelObject extends Entity {

	public String text = "";
	public Color color = Color.WHITE;
	public boolean willDestroy = false;
	int destroyTimer = 100;
	
	public TextLabelObject(double x, double y,String text) {
		super(x, y);
		this.text = text;
	}
	
	public void tick(){
		if(willDestroy){
			if(destroyTimer > 0){
				destroyTimer -= 1;
				y -= 1;
			}else{
				Game.getCurrentScene().destroyInstance(this);
			}
		}
	}
	
	public void draw(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect((int)x, (int)y, 8*text.length(), 16);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g2d.setColor(color);
		g2d.setFont(new Font(Font.SERIF,14,14));
		g2d.drawString(text, (int)x, (int)y+14);
	}

}
