package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Creates buttons based on images.
 */
public class SudokuButton extends JButton {
	/**
	 * Classes that implement <code>Serializable</code> needs this.
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 2365297238606073795L;
	
	private Image backgroundImage;
	
	/**
	 * Creates a button based on the supplied image.
	 * @param imageFile The image to use as a background.
	 */
	public SudokuButton(String imageFile) {
		super();
		
		/*
		 * Load the image and save it.
		 */
		ImageIcon tempImage = null;
		tempImage = new ImageIcon(getClass().getResource("graphics/" + imageFile));
		backgroundImage = tempImage.getImage();
		
		/*
		 * Set the size and make sure the buttons background is transparent.
		 */
		this.setSize(150, 100);
		this.setPreferredSize(this.getSize());
		this.setContentAreaFilled(false);
	}
	
	/**
	 * Overrides the paint-method to make sure that the image
	 * gets drawed.
	 */
	public void paint(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, this);
		}
	}

}
