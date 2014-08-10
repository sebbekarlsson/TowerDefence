package nu.sebka.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ImageLoader {

	public static BufferedImage load(String imagepath){
		try {
			return ImageIO.read(ImageLoader.class.getResourceAsStream(imagepath));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not load "+imagepath);
			e.printStackTrace();
		}
		
		return null;
	}
}
