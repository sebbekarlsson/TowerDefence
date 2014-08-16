package nu.sebka.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nu.sebka.main.gui.GUIObject;
import nu.sebka.scenes.MenuScene;
import nu.sebka.scenes.worlds.World0;
import nu.sebka.scenes.worlds.World1;
import nu.sebka.scenes.worlds.World2;
import nu.sebka.scenes.worlds.World3;
import nu.sebka.scenes.worlds.World4;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;

	static final int WIDTH = 640;
	static final int HEIGHT = WIDTH / 16 * 9;
	static final int SCALE = 2;
	public static final Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	public static final Dimension RENDERSIZE = new Dimension(FRAMESIZE.width, FRAMESIZE.height);

	static JFrame frame = new JFrame();

	public static final BufferedImage offscreen = new BufferedImage(RENDERSIZE.width, RENDERSIZE.height, BufferedImage.TYPE_INT_RGB);

	public final Thread gameLoop = new Thread(this);

	public static ArrayList<Scene> scenes = new ArrayList<Scene>();
	public static int sceneIndex = 0;

	public static char keychar = "|".charAt(0);
	public static boolean keyDown = false;
	public static boolean[] keys = new boolean[256];
	public static boolean[] mkeys = new boolean[10];

	public static int DEFAULT_MONEY = 180;
	public static int money = DEFAULT_MONEY;
	public static int kills = 0;

	public static Instance boughtObject;


	public Game(){

		scenes.add(new MenuScene());
		scenes.add(new World0());
		scenes.add(new World1());
		scenes.add(new World2());
		scenes.add(new World3());
		scenes.add(new World4());

		frame.setSize(FRAMESIZE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);

		frame.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);



		frame.add(this);
	}

	public static void main(String[] args){
		Game game = new Game();
		game.start();
	}

	public void start(){
		gameLoop.start();
	}


	@Override
	public void run() {

		while(true){

			tick();
			

			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void tick(){
		
		for(int i = 0; i < getCurrentScene().instances.size(); i++){
			Instance instance = getCurrentScene().instances.get(i);
			if(!Terminal.isOpen()){
				instance.tick();
				instance.defaultTick();
			}

		}
		
		getCurrentScene().tick();
		getCurrentScene().defaultTick();

		
		for(int i = 0; i < getCurrentScene().guiobjects.size(); i++){
			GUIObject object = getCurrentScene().guiobjects.get(i);
			object.tick();
		}
		
		if(Terminal.isOpen()){
			Terminal.tick();
		}
		
		

	}

	public void paint(Graphics g){

		Graphics2D g2d = (Graphics2D) offscreen.getGraphics();


		g2d.clearRect(0, 0, RENDERSIZE.width, RENDERSIZE.height);
		Graphics2D GUI = (Graphics2D) g2d;

		getCurrentScene().draw(g2d);

		for(int i = 0; i < getCurrentScene().instances.size(); i++){
			Instance instance = getCurrentScene().instances.get(i);
			if(instance != null)
			instance.draw(g2d);
		}

		getCurrentScene().drawGUI(GUI);
		if(Terminal.isOpen()){
			Terminal.draw(GUI);
		}
		MouseHandler.draw(GUI);

		for(int i = 0; i < getCurrentScene().guiobjects.size(); i++){
			GUIObject object = getCurrentScene().guiobjects.get(i);
			object.draw(GUI);
		}
		
		g.drawImage(offscreen, 0, 0, FRAMESIZE.width, FRAMESIZE.height, this);

		repaint();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		mkeys[e.getButton()] = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mkeys[e.getButton()] = false;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		keyDown = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		keychar = "|".charAt(0);
		keyDown = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		keychar = e.getKeyChar();

	}


	public static Scene getCurrentScene(){
		return scenes.get(sceneIndex);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		MouseHandler.setMousePosition(e.getX(), e.getY());

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MouseHandler.setMousePosition(e.getX(), e.getY());

	}



}
