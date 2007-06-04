/**
 * 
 */
package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Julian
 *
 */
public class Header extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8743662851484656254L;
	
	private Image backgroundImage;
	
	public Header() {
		ImageIcon tempImage = null;
		tempImage = new ImageIcon(getClass().getResource("graphics/header.png"));
		backgroundImage = tempImage.getImage();
		
		this.setOpaque(false);
		this.setSize(400, 100);
		this.setPreferredSize(this.getSize());
	}
	
	public void paint(Graphics g) {
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, this);
		}
		super.paint(g);
	}

}
