package nu.sebka.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Terminal {

	static boolean show = false;
	static String input = "";

	static ArrayList<String> history = new ArrayList<String>();

	public static void tick(){
		if(!Game.keys[KeyEvent.VK_BACK_SPACE]){
			if(Game.keychar != "|".charAt(0)){
				if(Game.keyDown){
					input += Game.keychar;
					Game.keyDown = false;
				}
			}
		}

		if(Game.keys[KeyEvent.VK_BACK_SPACE]){

			if(input.length() > 0){
				if(Game.keyDown){
					input = input.substring(0, input.length()-1);
					Game.keys[KeyEvent.VK_BACK_SPACE] = false;
					Game.keyDown = false;
				}
			}
		}

		if(Game.keys[KeyEvent.VK_ENTER]){
			if(input.length() > 0){
				history.add(">"+input);
				show = CommandReader.read(input);
				input = "";
			}
			Game.keys[KeyEvent.VK_ENTER] = false;
		}


		if(Game.keys[KeyEvent.VK_UP]){
			if(history.size() > 0){
				input = history.get(history.size()-1).replace(">", "");
				Game.keys[KeyEvent.VK_UP] = false;
			}
		}
	}

	public static void draw(Graphics2D g2d){
		g2d.setColor(Color.black);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
		g2d.fillRect(32, 32, Game.RENDERSIZE.width-64, Game.RENDERSIZE.height-86);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SERIF,22,22));
		g2d.drawString(">"+input+"|", 42, Game.RENDERSIZE.height-87);

		for(int i = 0; i < history.size(); i++){
			String h = history.get(i);
			if(i*22 < Game.RENDERSIZE.height-186){
				g2d.drawString(h, 42, 64+22*i);
			}else{
				history.clear();
			}
		}
	}

	public static void open(){
		show = true;
	}

	public static void close(){
		show = false;
	}

	public static boolean isOpen(){
		return show;
	}

	public static void write(String s){
		history.add(s);
	}

}
