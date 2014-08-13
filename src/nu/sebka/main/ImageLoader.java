package nu.sebka.main;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.JOptionPane;

import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.gif.GIFImageReaderSpi;

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
	
	public static ArrayList<BufferedImage> getFrames(String imagepath){
	    
	    
	    try {
	    	ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
		    ImageReader ir = new GIFImageReader(new GIFImageReaderSpi());
			ir.setInput(ImageIO.createImageInputStream(ImageLoader.class.getResourceAsStream(imagepath)));
			for(int i = 0; i < ir.getNumImages(true); i++){
		        frames.add(ir.read(i));
		    }
		    return frames;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	    
	}
}
