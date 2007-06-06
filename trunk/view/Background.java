package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Handles the drawing of the backgroundimage.
 */
public class Background extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4031414845777706266L;
	
	/**
	 * The backgroundimage which gets drawed.
	 */
	private Image backgroundImage;
	
	/**
	 * Creates a new backgroundimage from the supplied
	 * image with the specified dimension.
	 * @param imageFile The image to load
	 * @param dim The dimension of the image
	 */
	public Background(String imageFile, Dimension dim) {
		/*
		 * Create a ImageIcon from the specified imageFile
		 * and save the Image from the ImageIcon in backgroundImage.
		 */
		ImageIcon tempImage = null;
		tempImage = new ImageIcon(getClass().getResource("graphics/" + imageFile));
		backgroundImage = tempImage.getImage();
		
		/*
		 * Set the size and make sure the panel isn't opaque.
		 */
		this.setSize(dim);
		this.setPreferredSize(this.getSize());
		this.setOpaque(false);
	}
	
	/**
	 * Creates a new backgroundimage from the supplied
	 * image.
	 * @param imageFile The image to load
	 */
	public Background(String imageFile) {
		this(imageFile, new Dimension(700, 500));
	}
	
	/**
	 * Overrides the extended JPanel's paint-method
	 * so the image actually gets drawed.
	 */
	public void paint(Graphics g) {
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, this);
		}
		super.paintComponent(g);
	}
}
