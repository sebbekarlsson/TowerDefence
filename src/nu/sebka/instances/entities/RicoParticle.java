package nu.sebka.instances.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import nu.sebka.instances.Particle;

public class RicoParticle extends Particle {

	public RicoParticle(double x, double y) {
		super(x, y);
		health = 10;
	}
	
	public void draw(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect((int)x, (int)y, 2, 2);
	}

}
