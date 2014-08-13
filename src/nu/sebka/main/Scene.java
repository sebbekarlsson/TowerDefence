package nu.sebka.main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import nu.sebka.main.gui.GUIObject;

public class Scene {

	public int WIDTH = Game.RENDERSIZE.width;
	public int HEIGHT = Game.RENDERSIZE.height;
	public Dimension SCENESIZE = new Dimension(WIDTH,HEIGHT);
	
	public ArrayList<Instance> instances = new ArrayList<Instance>();
	public ArrayList<GUIObject> guiobjects = new ArrayList<GUIObject>();
	public Random random = new Random();
	
	
	public void tick(){
		
	}
	
	public void defaultTick(){
		
	}
	
	public void draw(Graphics2D g2d){
		
	}
	
	public void drawGUI(Graphics2D g2d){
		
	}
	
	public void createInstance(Instance instance){
		instances.add(instance);
		instance.onCreation();
	}
	
	public void replaceInstance(Instance instance1, Instance instance2){
		for(int i = 0; i < instances.size(); i++){
			Instance inst = instances.get(i);
			if(inst == instance2){
				instances.set(i, instance1);
				instance2.onReplacement();
			}
		}
	}
	
	public void destroyInstance(Instance instance){
		instances.remove(instance);
		instance.onDestroy();
		
		instance = null;
	}
	
	public void destroyGUIObject(GUIObject object){
		guiobjects.remove(object);
	}
	
	
	
	
}
