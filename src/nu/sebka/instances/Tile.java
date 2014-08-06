package nu.sebka.instances;

import java.awt.Color;
import java.awt.Graphics2D;

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
		// TODO Auto-generated method stub
		
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
