package nu.sebka.instances;

import java.awt.Color;
import java.awt.Graphics2D;



import nu.sebka.main.Game;
import nu.sebka.main.Instance;
import nu.sebka.main.MouseHandler;

public abstract class Tile extends Instance {

	public boolean isSelected = false;
	public boolean canBuild = false;
	
	public Tile(double x, double y) {
		super(x, y);
		
	}

	
	@Override
	public void defaultTick() {
		if(isSelected && canBuild){
			if(Game.mkeys[1]){
				if(Game.boughtObject != null){
				Game.boughtObject.x = x;
				Game.boughtObject.y = y;
				Game.getCurrentScene().createInstance(Game.boughtObject);
				Game.boughtObject = null;
				}
			}
		}
		
	}

	public void draw(Graphics2D g2d){
		drawSprite(g2d,sprite.getCurrentImage());
		drawHooverEffect(g2d);
	}
	public void drawHooverEffect(Graphics2D g2d){
		if(MouseHandler.getMousePosition().x >= x && MouseHandler.getMousePosition().x <= x + 32 && MouseHandler.getMousePosition().y >= y && MouseHandler.getMousePosition().y <= y + 32){
			g2d.setColor(Color.YELLOW);
			g2d.fillRect((int)x, (int)y, 32, 32);
			
			isSelected = true;
		}else{
			isSelected = false;
		}
		
	}
	

}
