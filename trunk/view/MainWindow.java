/**
 * 
 */
package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Julian
 *
 */
public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3172688540921699213L;

	public MainWindow() {
		super("LOL");
		
		/*
		 * Make sure the application exits when the close button is pressed.
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * Lay out the subcomponents correctly.
		 */
		this.validate();
		/*
		 * Disable resize of the window.
		 */
		this.setResizable(false);
		/*
		 * Place on the center of the screen.
		 */
		PlaceCenter.placeCenter(this);
		
		this.pack();
		
        super.add (new JLabel("Hello, World!"));
	}
}
