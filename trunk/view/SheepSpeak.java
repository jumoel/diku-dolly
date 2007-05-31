/**
 * 
 */
package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Julian
 *
 */
public class SheepSpeak extends JPanel {
	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = -8067997091581424848L;
	
	private String text;
	private Image backgroundImage;
	private JLabel label;
	private static String defaultText = "Hej, jeg er Dolly.<br><br>Tryk på \"Hjælp\" hvis du sidder fast.";
	
	public SheepSpeak() {
		text = defaultText;
		
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
	
	public void resetText() {
		this.setText(defaultText);
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
