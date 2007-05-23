/**
 * 
 */
package view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Handles the drawing of the backgroundimage.
 * @author Julian
 */
public class Background extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4031414845777706266L;
	
	private Image backgroundImage;
	
	public Background() {
		ImageIcon tempImage = null;
		tempImage = new ImageIcon(getClass().getResource("graphics/BG.jpg"));
		backgroundImage = tempImage.getImage();
		this.setSize(700, 500);
		this.setPreferredSize(this.getSize());
	}
	
	public void paint(Graphics g) {
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, this);
		}
	}
}
