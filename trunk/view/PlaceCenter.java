/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Class containg function to center a component.
 */
public abstract class PlaceCenter {
	/**
	 * Places the <code>component</code> on the center
	 * of the screen.
	 * 
	 * @param component The component to center.
	 */
	public static void placeCenter(Component component)
	{
		/*
		 * Get the default toolkit
		 */
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		/*
		 * Get the current screen size and the current windowsize
		 */
		Dimension screensize = toolkit.getScreenSize();
		Dimension windowsize = component.getSize();
		int xpos = (screensize.width - windowsize.width) / 2;
		int ypos = (screensize.height - windowsize.height) / 2;

		/*
		 * Set's the location to the middle of the screen
		 */
		component.setLocation(xpos, ypos);
		
		/*
		 * Clean up
		 */
		toolkit = null; screensize = null; windowsize = null;
	}
}
