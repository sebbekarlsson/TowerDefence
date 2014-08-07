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

import nu.sebka.scenes.worlds.World0;

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

	public static boolean[] keys = new boolean[256];
	public static boolean[] mkeys = new boolean[10];
	
	public static int money = 1500;
	

	public Game(){
		
		scenes.add(new World0());
		
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
			for(int i = 0; i < getCurrentScene().instances.size(); i++){
				Instance instance = getCurrentScene().instances.get(i);
				instance.tick();
				instance.defaultTick();
				
			}

			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void tick(){
		getCurrentScene().tick();
		
	}

	public void paint(Graphics g){
		
		Graphics2D g2d = (Graphics2D) offscreen.getGraphics();
		
		
		g2d.clearRect(0, 0, RENDERSIZE.width, RENDERSIZE.height);
		Graphics2D GUI = (Graphics2D) g2d;
		
		getCurrentScene().draw(g2d);
		
		for(int i = 0; i < getCurrentScene().instances.size(); i++){
			Instance instance = getCurrentScene().instances.get(i);
			instance.draw(g2d);
		}
		
		getCurrentScene().drawGUI(GUI);
		MouseHandler.draw(GUI);
		
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

	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

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
