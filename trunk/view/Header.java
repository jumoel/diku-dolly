package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * The headerimage (the "title").
 */
public class Header extends JPanel {
	private static final long serialVersionUID = 8743662851484656254L;
	
	private Image backgroundImage;
	
	/**
	 * Creates the header based on the headerimage.
	 */
	public Header() {
		/*
		 * Retrieve the image
		 */
		ImageIcon tempImage = null;
		tempImage = new ImageIcon(getClass().getResource("graphics/header.png"));
		backgroundImage = tempImage.getImage();
		
		/*
		 * Set the size and make sure the panel isn't opaque.
		 */
		this.setOpaque(false);
		this.setSize(400, 100);
		this.setPreferredSize(this.getSize());
	}
	
	/**
	 * Overrides the paint-method to make sure that the 
	 * image actually gets painted.
	 */
	public void paint(Graphics g) {
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, this);
		}
		super.paint(g);
	}

}
