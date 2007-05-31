/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Julian
 *
 */
public class SudokuButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2365297238606073795L;
	
	private Image backgroundImage;
	
	public SudokuButton(String imageFile) {
		super();
		ImageIcon tempImage = null;
		tempImage = new ImageIcon(getClass().getResource("graphics/" + imageFile));
		backgroundImage = tempImage.getImage();
		this.setSize(150, 100);
		this.setPreferredSize(this.getSize());
		this.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 5));
		//this.setBackground()
		this.setContentAreaFilled(false);
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, this);
		}
	}

}
