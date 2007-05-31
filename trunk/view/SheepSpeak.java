/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Julian
 *
 */
public class SheepSpeak extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8067997091581424848L;
	
	private String text;
	private Image backgroundImage;
	private JLabel label;
	
	public SheepSpeak() {
		text = "I R DOLLYLOL!<br>WELCUM 2 DUSOKU! SHOOOW ME THE MONAY!";
		
		ImageIcon tempImage = null;
		tempImage = new ImageIcon(getClass().getResource("graphics/bubble.png"));
		backgroundImage = tempImage.getImage();
		
		label = new JLabel("<html>" + text + "</html>");
		label.setSize(160, 128);
		label.setPreferredSize(label.getSize());
		label.setVerticalAlignment(JLabel.TOP);
		label.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		this.add(label);
		
		this.setOpaque(false);
		this.setSize(180, 180);
		this.setPreferredSize(this.getSize());
	}
	
	public void setText(String text) {
		this.text = text;
		label.setText("<html>" + this.text + "</html>");
	}
	
	public void paint(Graphics g) {
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, this);
		}
		super.paint(g);
	}
}
