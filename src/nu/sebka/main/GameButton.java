package nu.sebka.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class GameButton {

	public double x,y;

	public Sprite sprite = new Sprite();
	public String text = "";
	


	boolean isMouseOver = false;
	public abstract void onPress();

	public GameButton(double x, double y, BufferedImage image,String text){
		this.x = x;
		this.y = y;
		this.sprite.images.add(image);
		this.text = text;
	}

	public void tick(){
		double mx = MouseHandler.getMousePosition().x;
		double my = MouseHandler.getMousePosition().y;

		if(mx >= x && mx < x+sprite.getCurrentImage().getWidth() && my >= y && my <= y+sprite.getCurrentImage().getHeight()){
			isMouseOver = true;
			
			if(Game.mkeys[1]){
				onPress();
				Game.mkeys[1] = false;
			}
		}

		
		if(isMouseOver){
			if(sprite.images.size() > 1)
			sprite.imageindex = 1;
		}else{
			
			sprite.imageindex = 0;
		}

	}

	public void draw(Graphics2D g2d){
		
		g2d.drawImage(sprite.getCurrentImage(),(int)x,(int)y,null);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SERIF,14,14));
		
		
	
		
		g2d.drawString(text, (int)x+sprite.getCurrentImage().getWidth()/2-(text.length()*3), (int)y+25);
		
	}
}
